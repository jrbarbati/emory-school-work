%% Beauty Of Math
multiplyby = 1;
for i = 1:9;
    answer = multiplyby * 8 + i;
    fprintf('%d X 8 + %d = %d\n', multiplyby, i, answer);
    multiplyby = multiplyby * 10 + i + 1;
end 
