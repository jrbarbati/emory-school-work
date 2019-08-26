function [ nowinner ] = checkwinner( board )
%CHECKWINNER Returns true if there is no winner
%   Checks a tic-tac-toe board of 1s and -1s for a winner by summing
%   columns, rows and diagonals.

%check rows
rowsums = nansum(board, 2);
rows = max(abs(rowsums));

%check columns
colsums = nansum(board, 1);
cols = max(abs(colsums));

%check diagonals
diag1 = nansum(diag(board));
diag1 = abs(diag1);
diag2 = nansum(diag(fliplr(board)));
diag2 = abs(diag2);

%check if any sums equal 3 (since 3 indicates a win)
if rows == 3 || cols == 3 || diag1 == 3 || diag2 == 3
    nowinner = false;
else
    nowinner = true;
end

end