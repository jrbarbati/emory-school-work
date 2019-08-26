%% Chapter 7 and 8 Homework
%Chapter 7 - 2, 6, 10, 15, 19
%Chapter 8 - 2, 10, 12, 23

%% Chapter 7
% Number 2
% nameCheck.m

% Number 6
% toString.m

% Number 10
% namedept.m

% Number 15
randInt = randi(100);
fieldWidth = input('Please enter a field width (integer): ');
fprintf(sprintf('The # is %%%dd\n', fieldWidth), randInt);

% Number 19
% nchars.m

%% Chapter 8

% Number 2
cellMat = cell(2,2);
cellMat{1,1} = 12;
cellMat{1,2} = 'What';
cellMat{2,1} = [1:2;3:4];
cellMat{2,2} = [1:3];

%% Number 10
matCell = cell(1, 3);
for i = 1:6
    if i <= 3
        inputVec = input('Please enter a vector: ');
        matCell{1, i} = inputVec;
    else
        fprintf('Length of vector %d is: %d\n', (i - 3),... 
            length(matCell{1, (i - 3)}));
    end
end

%% Number 12
student = struct('Name', 'Joseph', 'Student_ID', '2048071', 'GPA', 4.0);
fprintf('Name: %s \nStudent ID: %s \nGPA: %.1f\n', student.Name, ...
    student.Student_ID, student.GPA);

%% Number 23
% printLines.m --> prints the desired table
lineSeg(1) = struct('line', 1, 'from', struct('x', 3,'y', 5), ...
    'to', struct('x', 4, 'y', 7));
lineSeg(2) = struct('line', 2, 'from', struct('x', 5,'y', 6), ...
    'to', struct('x', 2, 'y', 10));
printLines(lineSeg);