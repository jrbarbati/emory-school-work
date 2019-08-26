%% Lab 5: MATLAB Programs - Wednesday, 2016-02-23
% This script runs a user vs. computer game of tic-tac-toe

%clear workspace
clear;

%initialize game settings
player = 1;
nmoves = 0;
nowinner = true;
board = nan(3);

%play game
while nmoves < 9 && nowinner
    
    %get a move from the user or the computer
    if player == 1
        %get user's move
        [r, c] = getmove();
        
        %check if user's move is valid
        while ~isnan(board(r,c))
            disp('Not a valid move')
            [r, c] = getmove();
        end
        
    else
        %generate a move
        pause(2);
        [r, c] = makemove(board);
        
        %check if computer's move is valid
        while ~isnan(board(r,c))
            [r, c] = makemove(board);
        end
    end
    
    %display move
    board = showmove(board, r, c, player);
    
    %check if move won
    nowinner = checkwinner(board);
    
    %switch player
    if player == 1
        player = -1;
    else
        player = 1;
    end
    
    %increment counter 
    nmoves = nmoves + 1;
end

%display final message
%check rows
rowsums = nansum(board, 2);

%check columns
colsums = nansum(board, 1);

%check diagonals
diag1 = nansum(diag(board));
diag2 = nansum(diag(fliplr(board)));

isTrue = false;
for i = 1:3 
    if rowsums(i) == -3 || colsums(i) == -3 || diag1 == -3 || diag2 == -3
        isTrue = true;
        disp('Computer won, good luck next time...');
        break;
    elseif rowsums(i) == 3 || colsums(i) == 3 || diag1 == 3 || diag2 == 3
        isTrue = true;
        disp('You won! Good job!');
        break;
    end
end
if ~isTrue
    disp('Draw.');
end
   