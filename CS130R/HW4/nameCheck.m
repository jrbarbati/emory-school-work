function [ isTrue ] = nameCheck( filename )
%NAMECHECK Checks to make sure the filename follows conventions
%   Checks to make sure the filename is in the form: 'filename.ext'
count = 0;
nums = int32(filename);
for i = 1:length(nums)
    if nums(i) < 97 && nums(i) ~= 46
        isTrue = false;
        return
    else
        if nums(i) == 46
            count = count + 1;
        isTrue = true;
        end
    end
end
isTrue = isTrue && count == 1;
end

