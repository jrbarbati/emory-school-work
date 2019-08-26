%% Lab 7: Data Structures - Wednesday, 2016-03-23
% This lab will focus on the use of two new data structures: cell arrays
% and structures.

%% Cell Arrays
% Let's begin by creating a cell array. Your cell array should contain at
% least three different data types as a row vector. Use the disp function
% to print your cell array
cellVec = {'String', [1 2; 3 4], 4.3};
disp(cellVec);

%% Referencing in Cell Arrays
% Use the class function to see the difference between indexing the second
% element of your cell array with {} and ().
disp(class(cellVec{2}));
disp(class(cellVec(2)));
disp(cellVec);

%% Removing and Replacing Elements in a Cell Array
% Remove the first element of your cell array. Then, replace the second
% element of your new cell array with the scalar 11. Think about which
% referencing method is necessary for each action.
cellVec(1) = [];
cellVec{2} = 11;
disp(cellVec);

%% Adding Elements to a Cell Array
% Add a new cell to the end of your cell array that contains the logical
% value true.
cellVec{3} = true;
disp(cellVec);

%% Structures
% Create a structure that represents information about you. It should be
% initialized with fields for your name, birthday, and eye color. Display
% the structure using the disp function.
about = struct('name', 'Joseph', 'birthday', '02/02/1995', 'eye_color', 'blue');
disp(about);

%% Referencing Fields in a Structure
% Use the fprintf function and your structure to print a statement that
% describes you. For example, 'Jane was born 01/02/03 and her eye color is
% brown.'
fprintf('%s was born on %s and his eye color is %s.\n', about.name, about.birthday, about.eye_color);

%% Adding a Field to a Structure
% Let's add a field to your structure that holds your current age.
about.age = 21;
disp(about);

%% Removing Fields from a Structure
% You decide that you don't want to have your age and birthday listed.
% Remove those fields from your structure.
about = rmfield(about, 'age');
about = rmfield(about, 'birthday');
disp(about);
%% Displaying Fields in a Structure
% Use the fieldnames function to display all remaining fields in your
% structure
disp(fieldnames(about));

%% Nested Data Structures
% Create a new field to your structure that uses a cell array to list your
% favorite animals. Use the disp function to print only the first animal in
% your cell array
about.animals = {'Dog', 'Cheetah'};
disp(about.animals{1});





