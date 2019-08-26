function layterms( input )
% LAYTERMS prints out a more relatable measure and units
% takes in an input string and separates it into a measuremeant and the
% units, the measurement is converted to a double then the two pieces are
% used in a subfunction, based on the units.

cellArray = strsplit(input);

% If cellArray has less than 2 elements, print error message
% If more than 2 elements, check what was entered and ask if user meant
% something else
% OR If cellArray has 2 elements, but one is empty, print error message
isTrue = false;
actualUnits = '';
meantUnits = '';
if numel(cellArray) < 2
    fprintf('Input string error: make sure it follows the following format: \n');
    fprintf('layterms(''measure unit'')\n');
    return;
elseif numel(cellArray) > 2
    for i = 2:numel(cellArray)
        meantUnits = strcat([meantUnits, ' ', cellArray{i}]);
    end
    [isTrue, actualUnits] = didYouMean(meantUnits);
else 
    if length(cellArray{2}) <= 0
        fprintf('Input string error: make sure it follows the following format: \n');
        fprintf('layterms(''measure unit'')\n');
        return;
    end
end

% If didYouMean changed the unit string, we set that to be 'units'
% otherwise we get units from cellArray itself
if isTrue
    units = actualUnits;
else
    % Gets units from input string
    units = cellArray{2};
end

% Gets the measurement and converts it to a double for calculation
measure = cellArray{1};
measure = str2double(measure);
% Checks to make sure measure is a number
% if layterms(' mm^3') is called, measure is NaN
if	isnan(measure)
    fprintf('Input string error: make sure it follows the following format: \n');
    fprintf('layterms(''measure unit'')\n');
    return;
end

% Checks what the units are and calls the repsective subfunction

%  VOLUME
if strcmp(units, 'mm^3') || strcmp(units, 'mm3') || strcmp(units, 'mm-cubed')
    volume(measure, 'mm^3');
elseif strcmp(units, 'cm^3') || strcmp(units, 'cm3') || strcmp(units, 'cm-cubed')
    volume(measure, 'cm^3');
elseif strcmp(units, 'm^3') || strcmp(units, 'm3') || strcmp(units, 'm-cubed')
    volume(measure, 'm^3');
elseif strcmp(units, 'km^3') || strcmp(units, 'km3') || strcmp(units, 'km-cubed')
    volume(measure, 'km^3');
elseif strcmp(units, 'in^3') || strcmp(units, 'in3') || strcmp(units, 'in-cubed')
    volume(measure, 'in^3');
elseif strcmp(units, 'ft^3') || strcmp(units, 'ft3') || strcmp(units, 'ft-cubed')
    volume(measure, 'ft^3');
elseif strcmp(units, 'floz') || strcmp(units, 'fl-oz')
    volume(measure, 'fl-oz');
elseif strcmp(units, 'liters') || strcmp(units, 'L') || strcmp(units, 'Liters')
    volume(measure, 'liters');
elseif strcmp(units, 'milliliters') || strcmp(units, 'mL') || strcmp(units, 'ml')
    volume(measure, 'milliliters');
    
% MASS
elseif strcmp(units, 'mg') || strcmp(units, 'milligrams') || strcmp(units, 'milligram')
    mass(measure, 'mg');
elseif strcmp(units, 'g') || strcmp(units, 'gram') || strcmp(units, 'grams')
    mass(measure, 'g');
elseif strcmp(units, 'lbs') || strcmp(units, 'lb') || strcmp(units, 'pound') || strcmp(units, 'pounds')
    mass(measure, 'lbs');
elseif strcmp(units, 'kg') || strcmp(units, 'kilograms') || strcmp(units, 'kilogram')
    mass(measure, 'kg');
elseif strcmp(units, 'oz') || strcmp(units, 'oz.') || strcmp(units, 'ounce') || strcmp(units, 'ounces')
    mass(measure, 'oz');
elseif strcmp(units, 't') || strcmp(units, 'US-t') || strcmp(units, 'US-ton')|| strcmp(units, 'US_t') ...
        || strcmp(units, 'tons') || strcmp(units, 'ton')
    mass(measure, 't');

% LENGTH
elseif strcmp(units, 'in') || strcmp(units, 'inch') || strcmp(units, 'inches')
    lengthlt(measure, 'in');
elseif strcmp(units, 'ft') || strcmp(units, 'foot') || strcmp(units, 'feet')
    lengthlt(measure, 'ft');
elseif strcmp(units, 'm') || strcmp(units, 'meter') || strcmp(units, 'meters')
    lengthlt(measure, 'm');
elseif strcmp(units, 'km') || strcmp(units, 'kilometer') || strcmp(units, 'kilometers')
    lengthlt(measure, 'km');
elseif strcmp(units, 'cm') || strcmp(units, 'centimeter') || strcmp(units, 'centimeters')
    lengthlt(measure, 'cm');
elseif strcmp(units, 'mm') || strcmp(units, 'millimeter') || strcmp(units, 'millimeters')
    lengthlt(measure, 'mm');
elseif strcmp(units, 'yd') || strcmp(units, 'yard') || strcmp(units, 'yards') || strcmp(units, 'yds')
    lengthlt(measure, 'yd');
elseif strcmp(units, 'mi') || strcmp(units, 'mile') || strcmp(units, 'miles')
    lengthlt(measure, 'mi');

% AREA
elseif strcmp(units, 'mm^2') || strcmp(units, 'mm2') || strcmp(units, 'mm-squared')
    area(measure, 'mm^2');
elseif strcmp(units, 'cm^2') || strcmp(units, 'cm2') || strcmp(units, 'cm-squared')
    area(measure, 'cm^2');
elseif strcmp(units, 'm^2') || strcmp(units, 'm2') || strcmp(units, 'm-squared')
    area(measure, 'm^2');
elseif strcmp(units, 'km^2') || strcmp(units, 'km2') || strcmp(units, 'km-squared')
    area(measure, 'km^2');
elseif strcmp(units, 'in^2') || strcmp(units, 'in2') || strcmp(units, 'in-squared')
    area(measure, 'in^2');
elseif strcmp(units, 'ft^2') || strcmp(units, 'ft2') || strcmp(units, 'ft-squared')
    area(measure, 'ft^2');
elseif strcmp(units, 'mi^2') || strcmp(units, 'mi2')||strcmp(units, 'mi-squared')
    area(measure, 'mi^2');
elseif strcmp(units, 'acre') || strcmp(units, 'acres') || strcmp(units, 'ac')
    area(measure, 'ac');
else 
    fprintf('Sorry, those units are not supported\n');
end % ends if
end % ends layterms()

function volume( measure, units )
%VOLUME takes in meaure and units and converts units to something more 
% relatable and converts the measure accordingly, then prints it to console
printMeasure = 0;
printUnits = '';
switch (units)
    case 'mm^3'
        if measure > 10000
            % Use iPhone 6s - 138.3mm x 67.1mm x 7.1mm - 65887.5mm^3
            printMeasure = measure / 65887.5;
            if printMeasure == 1.0
                printUnits = 'iPhone 6s';
            else
                printUnits = 'iPhone 6s''s';
            end
        else
            % Use sugar cube 4930mm^3
            printMeasure = measure / 4930;
            if printMeasure == 1.0
                printUnits = 'sugar cube';
            else
                printUnits = 'sugar cubes';
            end
        end
    case 'cm^3'
        if measure > 100
            % Use 13in Laptop - 1.8cm x 31.4cm x 21.9cm - 1,232.8cm^3
            printMeasure = measure / 1232.8;
            if printMeasure == 1.0
                printUnits = '13-in Laptop';
            else
                printUnits = '13-in Laptops';
            end
        else 
            % Use ping pong balls - 2in^3
            printMeasure = measure / 2;
            if printMeasure == 1.0
                printUnits = 'ping pong ball';
            else
                printUnits = 'ping pong balls';
            end
        end
    case 'in^3'
        if measure < 150
            % Use 13in Laptop - .71in x 12.35in x 8.62in - 75.6in^3
            printMeasure = measure / 75.6;
            if printMeasure == 1.0
                printUnits = '13-in Laptop';
            else
                printUnits = '13-in Laptops';
            end
        else
            % Basketball 434in^3
            printMeasure = measure / 434;
            if printMeasure == 1.0
                printUnits = 'basketball';
            else
                printUnits = 'basketballs';
            end
        end
    case 'm^3'
        % Use Cadillac Escalade - 20m^3
        printMeasure = measure / 20;
        if printMeasure == 1.0
            printUnits = 'Cadillac Escalade';
        else
            printUnits = 'Cadillac Escalades';
        end
    case 'ft^3'
        if measure > 25
            % Use Honda Civic - 113ft^3
            printMeasure = measure / 113;
            if printMeasure == 1.0
                printUnits = 'Honda Civic';
            else
                printUnits = 'Honda Civics';
            end
        else
            % Basketball .25804297ft^3
            printMeasure = measure / .25804297;
            if printMeasure == 1.0
                printUnits = 'basketball';
            else
                printUnits = 'basketballs';
            end
        end
    case 'fl-oz'
        if measure < 10000
            % Use glasses of water - 8 floz
            printMeasure = measure / 8;
            if printMeasure == 1.0
                printUnits = 'glass of water';
            else 
                printUnits = 'glasses of water';
            end
        else 
            % Use Neighborhood Swimming pools - 11690775.3 fl-oz
            printMeasure = measure / 11690775.3;
            if printMeasure == 1.0
                printUnits = 'swimming pool';
            else 
                printUnits = 'swimming pools';
            end
        end
    case 'km^3'
        if measure > 100
            % Mount Everest - 2143 km^3
            printMeasure = measure / 2143;
            if printMeasure == 1.0
                printUnits = 'Mount Everest';
            else
                printUnits = 'Mount Everests';
            end
        else
            % The Westin, ATL - 0.0005623310499269999 km^3
            printMeasure = measure / 0.0005623310499269999;
            if printMeasure == 1.0
                printUnits = 'Westin Hotel';
            else
                printUnits = 'Westin Hotels';
            end
        end
    case 'liters'
        if measure < 1000 
            % 20 fl-oz bottles of soda/water - .59148L
            printMeasure = measure / .59148;
            if printMeasure == 1.0
                printUnits = 'bottle of water';
            else
                printUnits = 'bottles of water';
            end
        else 
            % Olympic pool - 2.5M liters
            printMeasure = measure / 2500000;
            if printMeasure == 1.0
                printUnits = 'olympic size swimming pool';
            else
                printUnits = 'olympic size swimming pools';
            end
        end
    case 'milliliters'
        if measure > 1000
            % 20 fl-oz bottles - 568.26mL
            printMeasure = measure / 568.26;
            if printMeasure == 1.0
                printUnits = 'bottle of water';
            else
                printUnits = 'bottles of water';
            end
        else
            % 8 oz glasses - 227.304mL
            printMeasure = measure / 227.304;
            if printMeasure == 1.0
                printUnits = 'glass of water';
            else 
                printUnits = 'glasses of water';
            end
        end        
    otherwise
        return;
end % ends switch
fprintf('%.2f %s can fit into %.2f %s of space.\n', printMeasure, printUnits, ...
    measure, units);
fprintf('\n');

% If measure is above a certain threshold -- suggest using larger units
switch (units)
    case 'mm^3'
        if measure >= 1000000
            while true % Runs while input is anything but yes or no
                       % Same for all while loops in all subfunctions..
                fprintf('That might be hard to visualize...do you want to try converting from cm^3?');
                yesOrNo = input('(y/n): ', 's');
                fprintf('\n');
                if strcmp('y', yesOrNo) || strcmp('yes', yesOrNo)
                    measure = measure * 0.001;
                    volume(measure, 'cm^3');
                    break;
                elseif strcmp('n', yesOrNo) || strcmp('no', yesOrNo)
                    return;
                else 
                    fprintf('I don''t think I caught that...\n');
                    pause(1);
                end
            end
        end
    case 'cm^3'
        if measure >= 1000000
            while true
                fprintf('That might be hard to visualize...do you want to try converting from m^3?');
                yesOrNo = input('(y/n): ', 's');
                fprintf('\n');
                if strcmp('y', yesOrNo) || strcmp('yes', yesOrNo)
                    measure = measure * 0.000001;
                    volume(measure, 'm^3');
                    break;
                elseif strcmp('n', yesOrNo) || strcmp('no', yesOrNo)
                    return;
                else 
                    fprintf('I don''t think I caught that...\n');
                    pause(1);
                end
            end
        end
    case 'in^3'
        if measure >= 1000000
            while true
                fprintf('That might be hard to visualize...do you want to try converting from ft^3?');
                yesOrNo = input('(y/n): ', 's');
                fprintf('\n');
                if strcmp('y', yesOrNo) || strcmp('yes', yesOrNo)
                    measure = measure * 0.000578701;
                    volume(measure, 'ft^3');
                    break;
                elseif strcmp('n', yesOrNo) || strcmp('no', yesOrNo)
                    return;
                else 
                    fprintf('I don''t think I caught that...\n');
                    pause(1);
                end
            end
        end
    case 'm^3'
        if measure >= 10000000
            while true
                fprintf('That might be hard to visualize...do you want to try converting from km^3?');
                yesOrNo = input('(y/n): ', 's');
                fprintf('\n');
                if strcmp('y', yesOrNo) || strcmp('yes', yesOrNo)
                    measure = measure * 0.000000001;
                    volume(measure, 'km^3');
                    break;
                elseif strcmp('n', yesOrNo) || strcmp('no', yesOrNo)
                    return;
                else 
                    fprintf('I don''t think I caught that...\n');
                    pause(1);
                end
            end
        end
    case 'ft^3'
        if measure >= 10000000
            while true
                fprintf('That might be hard to visualize...do you want to try converting from km^3?');
                yesOrNo = input('(y/n): ', 's');
                fprintf('\n');
                if strcmp('y', yesOrNo) || strcmp('yes', yesOrNo)
                    measure = measure * 2.8317e-11;
                    volume(measure, 'km^3');
                    break;
                elseif strcmp('n', yesOrNo) || strcmp('no', yesOrNo)
                    return;
                else 
                    fprintf('I don''t think I caught that...\n');
                    pause(1);
                end
            end
        end
    case 'fl-oz'
        if measure >= 1000000
            while true
                fprintf('That might be hard to visualize...do you want to try converting from liters?');
                yesOrNo = input('(y/n): ', 's');
                fprintf('\n');
                if strcmp('y', yesOrNo) || strcmp('yes', yesOrNo)
                    measure = measure * 0.028413;
                    volume(measure, 'liters');
                    break;
                elseif strcmp('n', yesOrNo) || strcmp('no', yesOrNo)
                    return;
                else 
                    fprintf('I don''t think I caught that...\n');
                    pause(1);
                end
            end
        end        
    case 'milliliters'
        if measure >= 10000000
            while true
                fprintf('That might be hard to visualize...do you want to try converting from fl-oz?');
                yesOrNo = input('(y/n): ', 's');
                fprintf('\n');
                if strcmp('y', yesOrNo) || strcmp('yes', yesOrNo)
                    measure = measure * 0.0351952;
                    volume(measure, 'fl-oz');
                    break;
                elseif strcmp('n', yesOrNo) || strcmp('no', yesOrNo)
                    return;
                else 
                    fprintf('I don''t think I caught that...\n');
                    pause(1);
                end
            end
        end     
    otherwise
        return;
end % ends switch
end % ends volume()

function mass( measure, units )
% MASS units: mg,g,kg,lbs,oz,t(US)
% Layterms: mg--------penny(2500mg),food-long hair(1.9mg)
%           g---------penny(1penny=2.5g),13-inch Macbook Pro(2000g)
%           lbs-------basketball (1.4lbs),Labrador(80 lbs)
%           kg--------13-inch Macbook Pro (1pro=2kg),truck(2000kg)
%           oz--------iphone6s(5oz),Labrador(1280oz)
%           t(US)-----truck(1.5tons)
% MASS takes in meaure and units and converts units to something more 
% relatable and converts the measure accordingly, then prints it to console
printMeasure = 0;
printUnits = '';
switch (units)
    case 'mg'
        if measure > 1000
            % Use Penny - 1 penny=2500mg
            printMeasure = measure / 2500;
            if printMeasure == 1.0
                printUnits = 'penny';
            else
                printUnits = 'pennies';
            end
        else
            % Use foot long hair - 1 foot long hair=1.9mg
            printMeasure = measure /1.9;
            if printMeasure == 1.0
                printUnits = 'foot of hair';
            else
                printUnits = 'feet of hair';
            end
        end
    case 'g'
        if measure >= 2000
            % Use 13in Macbook Pro-1 Pro=2000g
            printMeasure = measure / 2000;
            if printMeasure == 1.0
                printUnits = '13-in Macbook Pro';
            else
                printUnits = '13-in Macbook Pros';
            end
        else 
            % Use penny-1 penny=2.5g
            printMeasure = measure / 2.5;
            if printMeasure == 1.0
                printUnits = 'penny';
            else
                printUnits = 'pennies';
            end
        end
    case 'lbs'
        if measure <= 140
            % Use Basketball-1.4 lbs
            printMeasure = measure / 1.4;
            if printMeasure == 1.0
                printUnits = 'basketball';
            else
                printUnits = 'basketballs';
            end
        else
            % Use Labrador-80 lbs
            printMeasure = measure / 80;
            if printMeasure == 1.0
                printUnits = 'Labrador';
            else
                printUnits = 'Labradors';
            end
        end
    case 'kg'
        if measure > 1000
            % Use truck-2000kg
            printMeasure = measure / 2000;
            if printMeasure == 1.0
            printUnits = 'truck';
        else
            printUnits = 'trucks';
            end
        else
            % Use 13in Macbook Pro-2kg
            printMeasure = measure / 2;
        
            if printMeasure == 1.0
            printUnits = '13in Macbook Pro';
            else
            printUnits = '13in Macbook Pros';
            end
        end    
    case 'oz'
        if measure < 1000
            % Use iPhone 6s-5oz
            printMeasure = measure / 5;
            if printMeasure == 1.0
                printUnits = 'iPhone 6s';
            else
                printUnits = 'iPhone 6s''s';
            end
        else
            % Use Labrador-1280 oz
            printMeasure = measure / 1280;
            if printMeasure == 1.0
                printUnits = 'Labrador';
            else
                printUnits = 'Labradodrs';
            end
        end
    case 't'
        % Use truck - 1.5t
        printMeasure = measure / 1.5;
        if printMeasure == 1.0
            printUnits = 'truck';
        else 
            printUnits = 'trucks';
        end
end % ends switch

fprintf('%.2f %s is equivalent to the weight of %.2f %s.\n', measure, units, ...
    printMeasure, printUnits);
fprintf('\n');

% If measure is above a certain threshold -- suggest using larger units
switch (units)
    case 'mg'
        if measure >= 2000000
            while true
                fprintf('That might be hard to visualize...do you want to try converting from g?')
                yesOrNo = input('(y/n): ', 's');
                fprintf('\n');
                if strcmp('y', yesOrNo) || strcmp('yes', yesOrNo)
                    measure = measure/1000;
                    mass(measure, 'g');
                    break;
                elseif strcmp('n', yesOrNo) || strcmp('no', yesOrNo)
                    return;
                else 
                    fprintf('I don''t think I caught that...\n');
                    pause(1);
                end
            end
        end
        
    case 'g'
        if measure >= 2000000
            while true
                fprintf('That might be hard to visualize...do you want to try converting from g?')
                yesOrNo = input('(y/n): ', 's');
                fprintf('\n');
                if strcmp('y', yesOrNo) || strcmp('yes', yesOrNo)
                    measure = measure/1000;
                    mass(measure, 'kg');
                    break;
                elseif strcmp('n', yesOrNo) || strcmp('no', yesOrNo)
                    return;
                else 
                    fprintf('I don''t think I caught that...\n');
                    pause(1);
                end
            end
        end
    case 'kg'
        if measure >= 2000000
            while true
                fprintf('That might be hard to visualize...do you want to try converting from g?')
                yesOrNo = input('(y/n): ', 's');
                fprintf('\n');
                if strcmp('y', yesOrNo) || strcmp('yes', yesOrNo)
                    measure = measure/907.185;
                    mass(measure, 't');
                    break;
                elseif strcmp('n', yesOrNo) || strcmp('no', yesOrNo)
                    return;
                else 
                    fprintf('I don''t think I caught that...\n');
                    pause(1);
                end
            end
        end
        
    case 'lbs'
        if measure >= 2000
            while true
                fprintf('That might be hard to visualize...do you want to try converting from g?')
                yesOrNo = input('(y/n): ', 's');
                fprintf('\n');
                if strcmp('y', yesOrNo) || strcmp('yes', yesOrNo)
                    measure = measure/2000;
                    mass(measure, 't');
                    break;
                elseif strcmp('n', yesOrNo) || strcmp('no', yesOrNo)
                    return;
                else 
                    fprintf('I don''t think I caught that...\n');
                    pause(1);
                end
            end
        end
    case 'oz'
        if measure >= 320000
            while true
                fprintf('That might be hard to visualize...do you want to try converting from g?')
                yesOrNo = input('(y/n): ', 's');
                fprintf('\n');
                if strcmp('y', yesOrNo) || strcmp('yes', yesOrNo)
                    measure = measure/32000;
                    mass(measure, 't');
                    break;
                elseif strcmp('n', yesOrNo) || strcmp('no', yesOrNo)
                    return;
                else 
                    fprintf('I don''t think I caught that...\n');
                    pause(1);
                end
            end
        end
    otherwise 
        return;
end % ends switch

end % ends mass()

function lengthlt( measure, units )
%LENGTHLT takes in meaure and units and converts units to something more 
% relatable and converts the measure accordingly, then prints it to console
printMeasure = 0;
printUnits = '';
switch (units)
    case 'in'
        if measure > 10000
            % Use stretch limo - 120 inches
            printMeasure = measure / 120;
            if printMeasure == 1.0
                printUnits = 'stretch limo';
            else
                printUnits = 'stretch limos';
            end
        else
            % Use red solo cup
            printMeasure = measure / 4.75;
            if printMeasure == 1.0
                printUnits = 'solo cup';
            else
                printUnits = 'solo cups';
            end
        end
    case 'ft'
        if measure > 1000
            % Use Empire State Building - 1454 ft to tip
            printMeasure = measure / 1454;
            if printMeasure == 1.0
                printUnits = 'Empire State Building';
            else
                printUnits = 'Empire State Buildings';
            end
        else 
            % Use hot dogs - 6 in standard size
            printMeasure = measure / .5;
            if printMeasure == 1.0
                printUnits = 'hot dog';
            else
                printUnits = 'hot dogs';
            end
        end
    case 'm'
        if measure < 30
            % Use school bus - 12.1 m
            printMeasure = measure / 12.1;
            if printMeasure == 1.0
                printUnits = 'school bus';
            else
                printUnits = 'school buses';
            end
        else
            % Use soccer ball .22 m
            printMeasure = measure / .22;
            if printMeasure == 1.0
                printUnits = 'soccer ball';
            else
                printUnits = 'soccer balls';
            end
        end
    case 'km'
        % Use Brooklyn Bridge 1.825 km
        printMeasure = measure / 1.825;
        if printMeasure == 1.0
            printUnits = 'Brooklyn Bridge';
        else
            printUnits = 'Brooklyn Bridges';
        end
    case 'cm'
        % Use dollar bill - 15.5956 cm
        printMeasure = measure / 15.5956;
        if printMeasure == 1.0
            printUnits = 'dollar bill';
        else 
            printUnits = 'dollar bills';
        end
    case 'mm'
        if measure > 100
            % Use hockey puck - 76 mm
            printMeasure = measure / 76;
            if printMeasure == 1.0
                printUnits = 'hockey puck';
            else
                printUnits = 'hockey pucks';
            end
        else
            % Use pennies - 19.05 mm
            printMeasure = measure / 19.05;
            if printMeasure == 1.0
                printUnits = 'penny';
            else
                printUnits = 'pennies';
            end
        end
    case 'yd'
        if measure > 100000
            % Use length of Rhode Island - 84480 yards
            printMeasure = measure / 84480;
            if printMeasure == 1.0
                printUnits = 'Rhode Island';
            else
                printUnits = 'Rhode Islands';
            end
        else 
            % Use king sized bed - 2.2222 yards
            printMeasure = measure / 2.2222;
            if printMeasure == 1.0
                printUnits = 'king-size bed';
            else
                printUnits = 'king-size beds';
            end
        end
    case 'mi'
        if measure < 100
            % Use Ponce de Leon Avenue - 7.65 miles
            printMeasure = measure / 7.65;
            if printMeasure == 1.0
                printUnits = 'Ponce de Leon Avenue';
            else
                printUnits = 'Ponce de Leon Avenues';
            end
        elseif measure > 15000
            % Use Great Wall of China - 13170.69 miles
            printMeasure = measure / 13170.69;
            if printMeasure == 1.0
                printUnits = 'Great Wall of China';
            else
                printUnits = 'Great Walls of China';
            end
        else
            % Use the New Jersey Turnpike - 122.4 miles
            printMeasure = measure / 122.4;
            if printMeasure == 1.0
                printUnits = 'New Jersey Turnpike';
            else 
                printUnits = 'New Jersey Turnpikes';
            end
        end  
    otherwise
        return;
end % ends switch

fprintf('%.2f %s is equivalent to %.2f %s laid end-to-end.\n', measure, units, ...
    printMeasure, printUnits);
fprintf('\n');

% If measure is above a certain threshold -- suggest using larger units
switch (units)
    case 'in'
        if measure > 10000
            while true
                fprintf('That may be hard to visualize... do you want to try converting from ft?');
                yesOrNo = input('(y/n):', 's');
                fprintf('\n');
                if strcmp('y', yesOrNo) || strcmp('yes', yesOrNo)
                    measure = measure / 12;
                    lengthlt(measure, 'ft');
                    break;
                elseif strcmp('n', yesOrNo) || strcmp('no', yesOrNo)
                    return;
                else 
                    fprintf('I don''t think I caught that...\n');
                    pause(1);
                end
            end
        end
    case 'ft'
        if measure > 10000
            while true
                fprintf('That may be hard to visualize... do you want to try converting from mi?');
                yesOrNo = input('(y/n):', 's');
                fprintf('\n');
                if strcmp('y', yesOrNo) || strcmp('yes', yesOrNo)
                    measure = measure / 5280;
                    lengthlt(measure, 'mi');
                    break;
                elseif strcmp('n', yesOrNo) || strcmp('no', yesOrNo)
                    return;
                else 
                    fprintf('I don''t think I caught that...\n');
                    pause(1);
                end
            end
        end
    case 'm'
        if measure > 10000
            while true
                fprintf('That may be hard to visualize... do you want to try converting from km?');
                yesOrNo = input('(y/n):', 's');
                fprintf('\n');
                if strcmp('y', yesOrNo) || strcmp('yes', yesOrNo)
                    measure = measure / 1000;
                    lengthlt(measure, 'km');
                    break;
                elseif strcmp('n', yesOrNo) || strcmp('no', yesOrNo)
                    return;
                else 
                    fprintf('I don''t think I caught that...\n');
                    pause(1);
                end
            end
        end
    case 'cm'
        if measure > 1000
            while true
                fprintf('That may be hard to visualize... do you want to try converting from m?');
                yesOrNo = input('(y/n):', 's');
                fprintf('\n');
                if strcmp('y', yesOrNo) || strcmp('yes', yesOrNo)
                    measure = measure / 100;
                    lengthlt(measure, 'm');
                    break;
                elseif strcmp('n', yesOrNo) || strcmp('no', yesOrNo)
                    return;
                else 
                    fprintf('I don''t think I caught that...\n');
                    pause(1);
                end
            end
        end
    case 'km'
        if measure > 100
            while true
                fprintf('That may be difficult to visualize... do you want to try converting from mi?');
                yesOrNo = input('(y/n):', 's');
                fprintf('\n');
                if strcmp('y', yesOrNo) || strcmp('yes', yesOrNo)
                    measure = measure / 1.60934;
                    lengthlt(measure, 'mi');
                    break;
                elseif strcmp('n', yesOrNo) || strcmp('no', yesOrNo)
                    return;
                else 
                    fprintf('I don''t think I caught that...\n');
                    pause(1);
                end
            end
        end
    case 'mm'
        if measure > 1000
            while true
                fprintf('That may be difficult to visualize... do you want to try converting from m?');
                yesOrNo = input('(y/n):', 's');
                fprintf('\n');
                if strcmp('y', yesOrNo) || strcmp('yes', yesOrNo)
                    measure = measure / 1000;
                    lengthlt(measure, 'm');
                    break;
                elseif strcmp('n', yesOrNo) || strcmp('no', yesOrNo)
                    return;
                else 
                    fprintf('I don''t think I caught that...\n');
                    pause(1);
                end
            end
        end
    case 'yd'
        if measure > 100000000
            while true
                fprintf('That may be difficult to visualize... do you want to try converting from mi?');
                yesOrNo = input('(y/n):', 's');
                fprintf('\n');
                if strcmp('y', yesOrNo) || strcmp('yes', yesOrNo)
                    measure = measure / 1760;
                    lengthlt(measure, 'yd');
                    break;
                elseif strcmp('n', yesOrNo) || strcmp('no', yesOrNo)
                    return;
                else 
                    fprintf('I don''t think I caught that...\n');
                    pause(1);
                end
            end
        end
    otherwise
        return;
end % ends switch

end % ends lengthlt()
function area( measure, units )
%AREA takes in meaure and units and converts units to something more 
% relatable and converts the measure accordingly, then prints it to console
printMeasure = 0;
printUnits = '';
switch (units)
    case 'cm^2'
            %Computer paper = 603.2246cm^2
            printMeasure = measure / 603.2246;
            if printMeasure == 1.0
                printUnits = 'Standard computer paper';
            else
                printUnits = 'Standard computer papers';
               
            end
       
    case 'mm^2'
            % Use a US penny =  283.38mm^2
            printMeasure = measure / 283.38;
            if printMeasure == 1.0
                printUnits = 'US penny';
            else
                printUnits = 'US pennies';
            end
        
    case 'in^2'
            % MLB home plate = 216.5 in^2
            printMeasure = measure / 216.5;
            if printMeasure == 1.0
                printUnits = 'Home plate';
            else
                printUnits = 'Home plates';
               
            end
    case 'm^2'
        % NBA basketball court = 435 m^2
        printMeasure = measure / 435;
        if printMeasure == 1.0
            printUnits = 'Basketball court';
        else
            printUnits = 'Basketball courts';
        end
    case 'ft^2'
            % IPad = 0.313611111 ft^2
            printMeasure = measure / 0.313611111;
            if printMeasure == 1.0
                printUnits = 'iPad';
            else
                printUnits = 'iPads';
            end
    case 'ac'
        % Grand Canyon National Park = 1217280 ac
        printMeasure = measure / 1217280 ;
        if printMeasure == 1.0
            printUnits = 'Grand Canyon National Park';
        else 
            printUnits = 'Grand Canyon National Parks';
        end
    case 'km^2'
            % Running track = 0.01002700 km^2
            printMeasure = measure / 0.01002700;
            if printMeasure == 1.0
                printUnits = 'Running Track';
            else
                printUnits = 'Running Tracks';
            end
    case 'mi^2'
            % Central Park, NY = 1.317 mi^2
            printMeasure = measure / 1.317;
            if printMeasure == 1.0
                printUnits = 'Central Park';
            else
                printUnits = 'Central Parks';
            end       
    otherwise
        return;
end % ends switch
fprintf('%.2f %s could fit into %.2f %s of space.\n', printMeasure, printUnits, ...
    measure, units);
fprintf('\n');

% If measure is above a certain threshold -- suggest using larger units
switch (units)
    case 'cm^2'
        if measure >= 10000
            while true
                fprintf('That might be hard to visualize... do you want to try converting to m^2')
                yesOrNo = input('(y/n):', 's');
                fprintf('\n');
                if strcmp('y', yesOrNo) || strcmp('yes', yesOrNo)
                    measure = measure *0.01;
                    area(measure, 'm^2');
                    break;
                elseif strcmp('n', yesOrNo) || strcmp('no', yesOrNo)
                    return;
                else 
                    fprintf('I don''t think I caught that...\n');
                    pause(1);
                end
            end
        end
  case 'mm^2'
        if measure >= 10000
            while true
                fprintf('That might be hard to visualize... do you want to try converting to cm^2')
                yesOrNo = input('(y/n):', 's');
                fprintf('\n');
                if strcmp('y', yesOrNo) || strcmp('yes', yesOrNo)
                    measure = measure *0.1;
                    area(measure, 'm^2');
                    break;
                elseif strcmp('n', yesOrNo) || strcmp('no', yesOrNo)
                    return;
                else 
                    fprintf('I don''t think I caught that...\n');
                    pause(1);
                end
            end
        end
  case 'in^2'
        if measure >= 10000
            while true
                fprintf('That might be hard to visualize... do you want to try converting to ft^2')
                yesOrNo = input('(y/n):', 's');
                fprintf('\n');
                if strcmp('y', yesOrNo) || strcmp('yes', yesOrNo)
                    measure = measure * 0.08333;
                    area(measure, 'ft^2');
                    break;
                elseif strcmp('n', yesOrNo) || strcmp('no', yesOrNo)
                    return;
                else 
                    fprintf('I don''t think I caught that...\n');
                    pause(1);
                end
            end
        end   
    case 'm^2'
        if measure >= 100000
            while true
                fprintf('That might be hard to visualize... do you want to try converting to km^2')
                yesOrNo = input('(y/n): ', 's');
                fprintf('\n');
                if strcmp('y', yesOrNo) || strcmp('yes', yesOrNo)
                    measure = measure *0.001;
                    area(measure, 'km^2');
                    break;
                elseif strcmp('n', yesOrNo) || strcmp('no', yesOrNo)
                    return;
                else 
                    fprintf('I don''t think I caught that...\n');
                    pause(1);
                end
            end
        end
   case 'ft^2'
        if measure >= 1000000
            while true
                fprintf('That might be hard to visualize... do you want to try converting to ac')
                yesOrNo = input('(y/n): ', 's');
                fprintf('\n');
                if strcmp('y', yesOrNo) || strcmp('yes', yesOrNo)
                    measure = measure * 2.29568e-5;
                    area(measure, 'ac');
                    break;
                elseif strcmp('n', yesOrNo) || strcmp('no', yesOrNo)
                    return;
                else 
                    fprintf('I don''t think I caught that...\n');
                    pause(1);
                end
            end
        end     
    case 'ac'
        if measure >= 1000000
            while true
                fprintf('That might be hard to visualize... do you want to try converting to mi^2')
                yesOrNo = input('(y/n): ', 's');
                fprintf('\n');
                if strcmp('y', yesOrNo) || strcmp('yes', yesOrNo)
                    measure = measure * 0.0015625;
                    area(measure, 'mi^2');
                    break;
                elseif strcmp('n', yesOrNo) || strcmp('no', yesOrNo)
                    return;
                else 
                    fprintf('I don''t think I caught that...\n');
                    pause(1);
                end
            end
        end   
    otherwise
        return;
end % ends switch 
end % ends area()
