function [ r,c ] = makemove(board) 
%MAKEMOVE computer's move
%Cheks the sums of each row, col, and diagonal and first sees if it can win
%(checks for -2) then if it can stop the user from winning (checks for 2)
%and makes a move into the spot that is open in each of those siutation.
%If neither situation exists, it goes for the corners
%rowsums is a vector of the sums of each row
%colsums is a vector of the sums of each column
%diag1 is a sum of the main diagonal
%diag2 is a sum of the off diagonal
        
%check rows
rowsums = nansum(board, 2);
rows = abs(rowsums);
rowsmax = max(rows);

%check columns
colsums = nansum(board, 1);
cols = abs(colsums);
colsmax = max(cols);

%check diagonals
diag1 = nansum(diag(board));
diag1abs = abs(diag1);
diag2 = nansum(diag(fliplr(board)));
diag2abs = abs(diag2);
if ((rowsmax == 2) || (colsmax == 2) || (diag1abs == 2) || (diag2abs == 2))
    for i = 1:3 
        if rowsums(i) == -2
            r = i;
            c = 1;
            while ~isnan(board(r,c))
            c = c + 1;
            end
        elseif colsums(i) == -2
            r = 1;
            c = i;
            while ~isnan(board(r,c))
                r = r + 1;
            end
        end
    end
    if diag1 == -2
        r = 1;
        c = 1;
        while ~isnan(board(r,c))
            r = r + 1;
            c = c + 1;
        end
    elseif diag2 == -2
        r = 1;
        c = 3;
        while ~isnan(board(r,c))
            r = r + 1;
            c = c - 1;
        end
    end
    for i = 1:3 
        if rowsums(i) == 2
            r = i;
            c = 1;
            while ~isnan(board(r,c))
                c = c + 1;
            end
        elseif colsums(i) == 2
            r = 1;
            c = i;
            while ~isnan(board(r,c))
                r = r + 1;
            end
        end
    end
    if diag1 == 2
        r = 1;
        c = 1;
        while ~isnan(board(r,c))
            r = r + 1;
            c = c + 1;
        end
    elseif diag2 == 2
        r = 1;
        c = 3;
        while ~isnan(board(r,c))
            r = r + 1;
            c = c - 1;
        end
    end
else 
    r = randi([1,3]);
    c = randi([1,3]);
    while ~isnan(board(r,c))
        r = randi([1,3]);
        c = randi([1,3]);
    end
end
end 