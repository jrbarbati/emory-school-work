function [ survivors ] = calcsurvival( reportedCases, reportedDeaths )
%CALCSURVIVAL Calculates the number of Ebola Survivors from the outbreak in
%Western Africa in 2014
% This takes two matrices, one for reported cases and another for reported
% deaths caused by ebola.  It subtracts the number of cases from the number
% of deaths to calculate the number of total survivors and returns that
% number.
survivors = reportedCases - reportedDeaths;

end

