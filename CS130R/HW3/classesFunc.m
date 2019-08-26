function [ choice ] = classesFunc(  )
%CLASSESFUNC Shows a menu with class options and returns what user chooses
%   Creates a menu and prompts user for response and returns the number
%   associated with the choice
isTrue = true;
while isTrue;
    choice = menu('Choose your favorite science class', 'Chemistry', ...
    'Physics', 'Biology');
    if (choice >= 1 && choice <= 3)
        isTrue = false;
    end
end
end

