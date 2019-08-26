%% Lab 1: Vectors and Matrices - Wednesday, 2016-01-27
% This lab will focus on the instantiation and manipulation of vectors and
% matrices. When you have completed this exercise, please upload your
% published work to your cs130r directory.

%% Getting Started
% You are currently working in a MATLAB m-file. Every line that begins with
% a % is called a comment. Comments are meant to be read by programmers,
% and are not interpreted by MATLAB. Comments that start with %% indicate
% the start of a new code Section. Each code Section can be run
% independently without having to run any other pieces of code. The
% location of your cursor will determine which code Section is active, and
% that section will be highlighted in yellow. Try running this code section
% by placing your cursor on the code below and clicking the "Run Section" 
% button in the toolbar above.

disp('Success');

%%
% You should now see the string 'Success' printed in your Command Window,
% but not any of the output from the Sections below.

%% Creating Row Vectors
% Row vectors are created by enclosing comma- or space-delimited numbers 
% in square brackets. Assign a row vector with the numbers 5, 6, 7, and 8
% to the variable rvec. To make your code more readable, I recommend making
% your vectors assignments comma-delimited.

rvec= [5, 6, 7, 8];
%%
% If you are making a row vector from a sequence of numbers, you can use
% the colon operator to make your life easier. To get a sequence of numbers
% from -1 to 3, you can use -1:3. Try making the same row vector rvec using
% the colon operator.

rvec = [5:8];
%%
% With the previous use of the colon operator, MATLAB assumed that you
% wanted your sequence to be spaced by 1. Use the help function to see if
% you can determine the syntax for creating differently spaced sequences of
% numbers. Now, assign a row vector rvec with values ranging from 20 to 30 
% in steps of 2.

rvec = [20:2:30];
%% Creating Column Vectors
% Column vectors are made in a similar way to row vectors, but each new row
% is delimited by a semicolon. Assign a column vector with the numbers 1, 
% 3, 15, and 42 to the variable cvec.

cvec = [1; 3; 15; 42];
%%
% We can also create a column vector by taking the transpose of a row
% vector. Used the help function to learn how to use the transpose
% operator. Now, create a new column vector called cvec by taking the
% transpose of row vector containing the number 5, 2, and 93.

rvec = [5, 2, 93];
cvec = transpose(rvec);
%% Creating Matrices
% To create a matrix, we need only combine the tools we learned for row and
% column vectors (i.e. columns are separated by commas or spaces and rows
% are separated by semicolons). Create a 2x2 matrix called mat using any
% values you choose.

mat = [1, 2; 3, 4];
%% Indexing
% Now that we have the tools to make vectors and matrices, let's see how we
% can manipulate them. Indexing allows us to access and modify parts of an
% array. Each position of a vector is sequentially numbered starting from
% 1. Use the doc function to learn the syntax for matrix indexing. Create a
% 4x3 matrix containing only zeros. Then, use indexing to assign the value
% 6 to position (3,2).

mat = zeros(4, 3);
mat(3, 2) = 6;
%%
% MATLAB has a convenient method for replace entire rows or columns in a
% single operation. Using the colon operator, replace row 1 of mat with the
% value 2.

mat(1,:) = 2;
%% Adding Elements
% Indexing can also be used to add elements to an existing vector or
% matrix. Make a 4 element column vector called addvec. Add an element to 
% the end that contains the value 8. You can do this by indexing the 5th 
% element.

addvec = [1; 2; 3; 4];
addvec(5, 1) = 8;
%% Deleting Elements
% What if we want to remove the element we just added to addvec? Well, we
% can remove it by replacing the 5th element with an empty vector. Use the 
% doc function to learn the syntax for an empty vector. Then, remove the
% 5th element of addvec.

addvec(5) = [];
%% Indexing with Vectors
% Changing elements one-by-one can be tedious if you need to make many
% modifications. Fortunately, you can use vectors to index multiple
% elements at the same time. Create a 4x4 matrix of zeros called modmat.
% Replace the elements (2,1), (2,2) and (2,3) with the value 3. (Hint:
% replace the column index with a vector)
modmat = zeros(4, 4);
modmat([1, 2, 3], 2) = 3;
%%
% There are many situations where we don't know how many elements a vector
% contains, but we need to access a subset of the elements. Assume you have
% a vector of unknown length called mystery, use the built-in expression
% end to assign the last 8 values of mystery to a new vector called subset.

mystery = 1:100;
subset = mystery([92:end]);
%% Logical Indexing
% Sometimes we want to get a subset of a vector or matrix rather than to
% modify elements. In this case, we can use logical indexing. By indexing a
% vector with a logical vector of the same size, we can access all of the
% elements in the vector that correspond to values of true in the logical
% vector. Make a 5 element row vector of number from 1 to 5 called bigset. 
% Make another 5 element vector with the sequence [0, 1, 0, 0, 1] called 
% logicidx, and cast it as logical. Now create another vector called 
% smallset by indexing bigset with logicidx.
bigset = [1:5];
logicidx = [0, 1, 0, 0, 1];
logicidx = logical(logicidx);
smallset = bigset(logicidx);

%% Dimensions
% Determining the number of elements of a vector or matrix is important for
% many debugging purposes. MATLAB has several functions for determining
% the dimensions of vectors and matrices. Create a 1x5 row vector called
% rvec, a 3x1 column vector called cvec, and a 7x4 matrix called mat.
% Try to figure out the different information returned by the function
% size, length, and numel. When are they the same? When are they different?
rvec = [1:5];
rvecLength = length(rvec);
rvecNumel = numel(rvec);
cvec = [1; 2; 3];
cvecLength = length(cvec);
cvecNumel = numel(cvec);
mat = ones(7, 4);
matSize = size(mat);
matLength = length(mat);
matNumel = numel(mat);
%size() returns the size of the matrix/vector (r, c)
%length() returns the number of rows of matrix, or the number of elements
%   in a vector
%numel() returns the number of elements in the matrix or vector
 
%% Changing Dimensions
% MATLAB has plenty of function for altering the dimensions of vectors and
% matrices. You can flip (fliplr and flipud), rotate (rot90, .'), or change
% dimensions (reshape). Create a 4x4 matrix called sqmat containing 
% the sequence of values from 1 to 16 (top to bottom then left to right).
% Create a 2x8 matrix called newmat by changing the dimensions of sqmat.
sqmat = [1, 5, 9, 13; 2, 6, 10, 14; 3, 7, 11, 15; 4, 8, 12, 16];
newmat = reshape(sqmat, 2, 8);

%% Challenge Questions
% If you are feeling comfortable with the material, feel free to try the 
% next few challenge questions.

%%
% Make a 5x8 matrix of random integers from 1 to 10. Using the tools you've
% learned, unwind (column-wise) the matrix into a 40x1 column vector.


%%
% The code below reads and displays an image. Insert one line of code
% between the two comments to swap the red channel (mxnx1) with the blue
% channel (mxnx3). (Hint: use a semicolon to suppress your output)

im = imread('ngc6543a.jpg');
%insert code below

%insert code above
image(im)
