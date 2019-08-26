%% HW5
% Chapter 9: 2, 6, 13, 21
% Chapter 10: 3, 8, 13, 28
%% Chapter 9

% Number 2
%Opening file
fid = fopen('xypts.dat');
if fid == -1
    fprintf('Error opening file\n');
    return;
end
%initializng vectors
xVec = zeros(1, 1);
yVec = zeros(1, 1);
%reading in lines and setting values to the corresponding vectors
for i = 1:10 % should use while ~feof(fid) for more robust code
    line = fgetl(fid);
    cellArr = strsplit(line);
    x = str2double(cellArr{2});
    y = str2double(cellArr{4});
    xVec(i) = x;
    yVec(i) = y;
end
%Creating plot of x,y coordinates
plot(xVec, yVec);
%Checking to make sure file closed properly
didClose = fclose(fid);
if didClose == 0
    fprintf('File closed\n');
else
    fprintf('File not closed properly\n');
    return;
end
%% Number 6
%Openning and checking it opened properly
fid = fopen('mathfile.dat');
if fid == -1
    fprintf('File not opened\n');
end
%Reading lines and printing output to screen
while ~feof(fid)
    line = fgetl(fid);
    cellArr = strsplit(line);
    op1 = str2double(cellArr{1});
    op2 = str2double(cellArr{3});
    if strcmp(cellArr{2}, '*')
        answer = op1 * op2;
        fprintf('%d %s %d = %d\n', op1, cellArr{2}, op2, answer);
    elseif strcmp(cellArr{2}, '/')
        answer = op1 / op2;
        fprintf('%d %s %d = %.2f\n', op1, cellArr{2}, op2, answer);
    elseif strcmp(cellArr{2}, '^')
        answer = op1^op2;
        fprintf('%d%s%d = %d\n', op1, cellArr{2}, op2, answer);
    elseif strcmp(cellArr{2}, '+')
        answer = op1 + op2;
        fprintf('%d %s %d = %d\n', op1, cellArr{2}, op2, answer);
    elseif strcmp(cellArr{2}, '-')
        answer = op1 - op2;
        fprintf('%d %s %d = %d\n', op1, cellArr{2}, op2, answer);
    elseif strcmp(cellArr{2}, '\')
        answer = op1 \ op2;
        fprintf('%d %s %d = %d\n', op1, cellArr{2}, op2, answer);
    end
end
%Closing file
didClose = fclose(fid);
if didClose == 0
    fprintf('File Closed\n');
else
    fprintf('File not closed\n');
end
%% Number 13
% Yes, load() can read stringsfile.dat, it takes in matrix formatted data,
% which this would be.
% Yes, textscan() can also read this in, assuming your second argument is
% '%s %s %s' so you get the strings back.

%% Number 21
% Openning file for writing
fid = fopen('3Dpoints.dat', 'w');
if fid == -1
    fprintf('Error opening file\n');
    return;
end
% Creating vectors
x = [1, 2, 3, 4, 5];
y = [1, 2, 3, 4, 5];
z = [1, 2, 3, 4, 5];

% Writing vectors to file in specified form (x 1 y 1 z 1)
for i = 1:length(x);
    fprintf(fid, 'x %d y %d z %d\n', x(i), y(i), z(i));
end
%Closing file
didClose = fclose(fid);
if didClose == 0
    fprintf('File Closed\n');
else
    fprintf('File not closed\n');
end
%% Chapter 10

% Number 3
cmtoinches = @(cm) cm * .394;
inchestocm = @(in) in * 2.54;
inchestofeet = @(in) in * 12;
feettoinches = @(feet) feet / 12;
feettometers = @(feet) feet * 3.28084;
meterstofeet = @(meters) meters * .3048;
save('lenconv.mat', 'cmtoinches', 'inchestocm', 'inchestofeet', ...
    'feettoinches', 'feettometers', 'meterstofeet');

%% Number 8
% plot2fnhand.m
xplus2Plot = @(x) x + 2;
squaredPlot = @(x) x.^2;
plot2fnhand(xplus2Plot, squaredPlot);

%% Number 13
% numbers.m
mat1 = numbers(3, 4);
mat2 = numbers(1, 2, 3);
mat3 = numbers(1);

%% Number 28
% fibonacci.m
for i = 0:20
    fprintf('%d\n', fibonacci(i));
end
