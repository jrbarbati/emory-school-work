function board = showmove( board, r, c, player )
%SHOWMOVE Displays the played move
%   Adds the played move to the game board and creates an updated display

%add move to board
board(r,c) = player;

%make figure of move
drawboard(board)

end

function drawboard( board )
%PLOTMOVE Creates a figure of the current board state
%   Shows the current state of the tic-tac-toe board as a figure

%set colors for blank, player 1 and player 2
blank = zeros(100,100,3)+255;
p1 = blank;
p1(:,:,[2,3]) = 0;
p2 = blank;
p2(:,:,[1,2]) = 0;

%update the rows and columns of the game board to reflect current board
for i = 1:3
    for j = 1:3
        %define current subplot
        subplot(3, 3, sub2ind([3,3],j,i))
        
        %set subplot depending on status of grid element
        switch board(i,j)
            case -1
                imshow(p2)
            case 1
                imshow(p1)
            otherwise
                imshow(blank)
        end
    end
end    

%add color key
subplot(3,3,2)
title('Red = Player 1     Blue = Player 2')
            
end
