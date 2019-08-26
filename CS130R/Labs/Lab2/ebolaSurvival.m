%% Ebola Outbreak in West Africa
% This script is meant to laod data from csv files
% Perform a survivor calculation 
% Plot the data from the survivor calculations and save that data
%% Loading CSV files
ebolaCases = csvread('ebolaCases.csv');
ebolaDeaths = csvread('ebolaDeaths.csv');
%% Survivor Calculation
numOfSurvivors = calcsurvival(ebolaCases, ebolaDeaths);
%% Plotting the Data (Cases)
plot(numOfSurvivors);
xlabel('Days');
ylabel('Number of Survivors');
title('Cumulative Survivors of Ebola (1 Mar 2014 - 12 Jan 2016)');
legend('Guinea', 'Liberia', 'Sierra Leone', 'Location', 'northwest');
%% Saving The Data to a File
save('ebolaSurvival.dat', 'numOfSurvivors', '-ascii');