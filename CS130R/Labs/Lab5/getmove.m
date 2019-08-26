function [ r, c ] = getmove()
%GETMOVE asks user for move 
r = input('Please insert the row number (1-3): ');  
c = input('Please insert the column number (1-3): ');
while (r < 1 || r > 3) && (c < 1 || c > 3)
    disp('Invalid entry. Trye again');
    r = input('Please insert the row number (1-3): ');  
    c = input('Please insert the column number (1-3): ');
end

    
end