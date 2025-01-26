package com.example.desing_pattern.behavioral.chain;

public class Main {
    public static void main(String[] args) {
        ImageUploader imageUploader = new ImageUploader(null);
        ImageCompressor compressor = new ImageCompressor(imageUploader);
        ImagePicker imagePicker = new ImagePicker(compressor);

        Uploader uploader= new Uploader(imagePicker);
        uploader.upload();
    }
}
