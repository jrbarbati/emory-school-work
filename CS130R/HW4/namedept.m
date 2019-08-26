function [ stringRep ] = namedept( name, department )
%NAMEDEPT returns a string of the first two letters of the name and last
%two of the department.
name = strcat(name(1), name(2));
depLength = length(department);
department = strcat(department(depLength - 1), department(depLength));
stringRep = strcat(name, department);
stringRep = upper(stringRep);