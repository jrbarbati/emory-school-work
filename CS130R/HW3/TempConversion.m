%% TempConversion
explainTC();
[min, max] = minmaxcheck();
toCelciusMat = zeros((max-min + 1), 2);
for i = 1:(max - min + 1)
    toCelciusMat(i,1) = min;
    toCelciusMat(i,2) = ((min - 32) * (5/9));
    min = min + 1;
end
writeTemps(toCelciusMat);