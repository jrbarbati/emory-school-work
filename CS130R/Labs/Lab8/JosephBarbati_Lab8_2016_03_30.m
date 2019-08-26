%% Lab 8: Advanced File I/O - Wednesday, 2016-03-30
% This lab will focus on low-level file I/O. The primary goal will be to
% extract a column of data from a file and use that data to create a
% histogram. Before we begin, be sure to inspect the file with a text
% editor.

%% Open File
% Bioinformatics is known for having some unwieldy data files. These files
% contain a variety of data types, unconventional delimiters, and typos.
% We'll learn low-level I/O by trying to extract a column of data from a 
% TCGA project file containing clinical information. Let's begin by opening  
% the data file for reading. Be sure to store the file identifier.
fid = fopen('nationwidechildrens.org_clinical_patient_gbm.txt', 'r');

% Now write an if statement to check whether the file was opened
% successfully. If the file was not opened properly, display a useful
% message and exit using the return function.
if fid == -1
    fprintf('ERROR: The file was not opened successfully.\n');
    return;
end

%% Read Headers
% This particular data file has three headers. Write a loop to read each 
% header line. For each header line, use the strsplit function to separate 
% the column names. The results should be stored in a three element cell
% array.
cellArray = cell(1, 3);
for i = 1:3
    line = fgetl(fid);
    cellArray{i} = strsplit(line);
end
%% Finding a Column
% We would like to extract data from one particular column of the data
% file. Use the strcmp function to create a logical vector identifying the
% location of the column for 'age_at_initial_pathologic_diagnosis'.
header = cellArray{1};
isWantedColumn = strcmp(header, 'age_at_initial_pathologic_diagnosis');

%% Read Data
% Now that we have read the header lines, MATLAB is positioned to read the
% fourth line containing the first row of our data. Write a loop to
% collect each line. Again, use the strsplit function to separate the
% columns. Instead of storing your results in a cell array, you should
% append only the value from the column of interest to a vector. Remember,
% you can access the column of interest using the logical vector from
% above. Also, data is read as a string. To recover the numeric values of a 
% string, use the str2double function.
j = 1;
dataArray = cell(1,2);
while ~feof(fid)
    data = fgetl(fid);
    mediator = strsplit(data, '\t');
    dataArray(j) = mediator(isWantedColumn);
    j = j + 1;
end
% converting each cell from string to double
for i = 1:length(dataArray)
    dataArray{i} = str2double(dataArray{i});
end
% converting cell array into a normal array of doubles
dataArray = cell2mat(dataArray);
% might be long way around the bar, but it works
%% Close File
% We have now extracted our desired data, and we are ready to close our
% file. Write the code to close the file, and include an if statement to
% ensure that the file closed successfully.
didClose = fclose(fid);
if didClose == 0
    fprintf('File closed\n');
else 
    fprintf('File not closed properly');
    return;
end

%% Plot Data
% Plot the data extracted from the file using the hist function. This will
% display a histogram of the ages of GBM patients at initial diagnosis.

hist(dataArray);