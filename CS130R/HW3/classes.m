%% Classes
% Prints a special message based on which science class the user chooses

answer = classesFunc();
switch answer
    case 1
        disp('Chemistry is hard, good luck in Orgo!');
    case 2
        disp('Physics isn''t easy, quantum theory blows my mind.');
    case 3
        disp('Biology isn''t the hardest thing in the world, but no science is easy...');
    otherwise
        disp('Hmm ... it seems you don''t like the sciences.');
end