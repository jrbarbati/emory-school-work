function printLines ( structVec )
%PRINTLINES prints the values of structVec in table-form
%structVec must be a vector of nested structures with a line, to, and from
%structs inside.
fprintf('Line   From      To\n');
fprintf('====   =======   =======\n');
for i = 1:length(structVec)
    fprintf('%d      (%d, %d)    (%d, %d)\n',structVec(i).line, ... 
        structVec(i).from.x, structVec(1).from.y, structVec(i).to.x, ...
        structVec(i).to.y);
end