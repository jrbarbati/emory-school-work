%% Lab 9: Advanced Function and Audio/Image Data - Wednesday, 2016-04-13
% This lab will combine the advanced functions discussed in Lecture 9 with
% the audio and image handling from Lecture 10. 

%% Vocal Reducer
% Everyone loves karaoke, but it can be hard to find the latest karaoke
% version of your favorite song. Fortunately, there is a neat trick to
% reduce the vocals on most stereo audio files that works well for creating
% karaoke songs. Let's start by reading in the audioclip.mp4 file. 
[y, freq] = audioread('audioclip.mp4');

%% Examining Audio Data
% First, inspect the audio data before we move on to the audio processing.
% How many dimensions does the audio data have? What is the sampling
% frequency? Is this stereo or mono audio data? Lastly, use the dimensions
% of the audio data and the sampling frequency to determine the time
% duration of the audio clip.
dimensRow = size(y, 1);
dimensCol = size(y, 2);
%Stereo file
duration = dimensRow / freq; %duration in seconds

%% Karaokize
% Now we are going to write an anonymous function that takes the audio data
% and reduces the main vocal track. To do this, your anonymous function
% should accept the audio data, invert the second channel and then combine
% the channels to convert from stereo to mono. To invert a channel, you can
% multiply by -1. To convert from stereo to mono, you can do the following
% (y(:,1)+y(:,2))/2. Once you have the anonymous function written, use it
% to reduce the vocals in the audio data from above. Feel free to listen to
% the processed audio data after class using the sound function.
reduceVocal = @( file ) (file(:,1)-file(:,2))/2;
monoAudio = reduceVocal(y);
%sound(monoAudio, freq);

%% Image Manipulation
% MATLAB is excellent when it comes to handling images. Let's learn how to
% do some basic image manipulations using the matrix operations we learned
% in previous lectures. Begin by reading in the emory.jpg image.
img = imread('emory.jpg');

%% Examining Image Data
% Take a moment to understand how the image data is stored in MATLAB. What
% are the dimensions of the image? Is it grayscale or color? Use the class
% function to determine the bit depth.
%1198x1597 and it's a color image
class(img); %uint8

%% Cropping
% Write an anonymous function that returns the top-left quarter of an
% image. In other words, your function should use indexing to return a
% cropped version of the image. Then, use your function to crop the image.
cropTopLeft = @( image ) image(1:600, 1:800,:);
croppedImage = cropTopLeft(img);

%% Display
% Use one of the display functions to inspect the original image and the
% cropped image.
image(img);
imshow(croppedImage);

%% Color Swap
% Write one last anonymous function that reverses the colors of the image.
% There are many ways to reverse the colors, but the primary goal is to
% swap the position of the red channel and the blue channel. Use your
% function and one of the display functions to visualize the results.
reverseColors = @( image ) 255 - image(:,:,:);
reversedImage = reverseColors(img);
image(reversedImage);
