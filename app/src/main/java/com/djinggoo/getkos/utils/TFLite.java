package com.djinggoo.getkos.utils;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;

import org.tensorflow.lite.Interpreter;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class TFLite {

    private Interpreter interpreter;
    private String MODEL_PATH = "model_getkos_regression-0.0.3.tflite";

    public TFLite(AssetManager assetManager){
        Interpreter.Options options = new Interpreter.Options();
        options.setNumThreads(5);
        options.setUseNNAPI(true);
        interpreter = new Interpreter(loadModelFile(assetManager, MODEL_PATH), options);
    }

    private MappedByteBuffer loadModelFile(AssetManager assetManager, String modelPath){
        try {
            AssetFileDescriptor fileDescriptor = assetManager.openFd(modelPath);
            FileInputStream inputStream = new FileInputStream(fileDescriptor.getFileDescriptor());
            FileChannel fileChannel = inputStream.getChannel();
            Long startOffset = fileDescriptor.getStartOffset();
            Long declareLength = fileDescriptor.getDeclaredLength();

            return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declareLength);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Float doInference(Float city, Float area, Float type, Float facilites){
        float[][] input = new float[][]{{city, area, type, facilites}};
        float[][] output = new float[1][1];
        interpreter.run(input, output);
        return output[0][0];
    }

}
