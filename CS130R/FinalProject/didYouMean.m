function [ trueOrFalse, output ] = didYouMean( units )
% DIDYOUMEAN asks user if they meant unit that is supported
% Takes in the units only if the units is two or more words
% Compares it to some possibilities and returns true and the units if it was changed
% If it wasn't changed, return false and an empty string
trueOrFalse = false;
output = '';
if strcmp(units, ' fl oz')
    trueOrFalse = true;
    meant = input('Did you mean fl-oz? (y/n) ', 's');
    if strcmp(meant, 'y')
        output = 'fl-oz';
    else 
        return;
    end
elseif strcmp(units, ' mm 3')
    trueOrFalse = true;
    meant = input('Did you mean mm^3? (y/n) ', 's');
    if strcmp(meant, 'y')
        output = 'mm^3';
    else 
        return;
    end
elseif strcmp(units, ' mm cubed')
    trueOrFalse = true;
    meant = input('Did you mean mm^3? (y/n) ', 's');
    if strcmp(meant, 'y')
        output = 'mm^3';
    else 
        return;
    end
elseif strcmp(units, ' cm 3')
    trueOrFalse = true;
    meant = input('Did you mean cm^3? (y/n) ', 's');
    if strcmp(meant, 'y')
        output = 'cm^3';
    else 
        return;
    end
elseif strcmp(units, ' cm cubed')
    trueOrFalse = true;
    meant = input('Did you mean cm^3? (y/n) ', 's');
    if strcmp(meant, 'y')
        output = 'cm^3';
    else 
        return;
    end
elseif strcmp(units, ' in 3')
    trueOrFalse = true;
    meant = input('Did you mean in^3? (y/n) ', 's');
    if strcmp(meant, 'y')
        output = 'in^3';
    else 
        return;
    end
elseif strcmp(units, ' in cubed')
    trueOrFalse = true;
    meant = input('Did you mean in^3? (y/n) ', 's');
    if strcmp(meant, 'y')
        output = 'in^3';
    else 
        return;
    end
elseif strcmp(units, ' ft 3')
    trueOrFalse = true;
    meant = input('Did you mean ft^3? (y/n) ', 's');
    if strcmp(meant, 'y')
        output = 'ft^3';
    else 
        return;
    end
elseif strcmp(units, ' ft cubed')
    trueOrFalse = true;
    meant = input('Did you mean ft^3? (y/n) ', 's');
    if strcmp(meant, 'y')
        output = 'ft^3';
    else 
        return;
    end
elseif strcmp(units, ' m 3')
    trueOrFalse = true;
    meant = input('Did you mean m^3? (y/n) ', 's');
    if strcmp(meant, 'y')
        output = 'm^3';
    else 
        return;
    end
elseif strcmp(units, ' m cubed')
    trueOrFalse = true;
    meant = input('Did you mean m^3? (y/n) ', 's');
    if strcmp(meant, 'y')
        output = 'm^3';
    else 
        return;
    end
elseif strcmp(units, ' km 3')
    trueOrFalse = true;
    meant = input('Did you mean km^3? (y/n) ', 's');
    if strcmp(meant, 'y')
        output = 'km^3';
    else 
        return;
    end
elseif strcmp(units, ' km cubed')
    trueOrFalse = true;
    meant = input('Did you mean km^3? (y/n) ', 's');
    if strcmp(meant, 'y')
        output = 'km^3';
    else 
        return;
    end
elseif strcmp(units, ' m L')
    trueOrFalse = true;
    meant = input('Did you mean milliliters? (y/n) ', 's');
    if strcmp(meant, 'y')
        output = 'mL';
    else 
        return;
    end
elseif strcmp(units,' o z')
    trueOrFalse = true;
    meant = input('Did you mean oz? (y/n) ', 's');
    if strcmp(meant, 'y')
        output = 'oz';
    else 
        return;
    end
elseif strcmp(units,' US tons') || strcmp(units,' US ton')
    trueOrFalse = true;
    meant = input('Did you mean tons? (y/n) ', 's');
    if strcmp(meant, 'y')
        output = 't';
    else 
        return;
    end
elseif strcmp(units,' milli liters') || strcmp(units,' milli liter')
    trueOrFalse = true;
    meant = input('Did you mean milliliters? (y/n) ', 's');
    if strcmp(meant, 'y')
        output = 'mL';
    else 
        return;
    end
elseif strcmp(units,' milli grams') || strcmp(units, ' milli gram')
    trueOrFalse = true;
    meant = input('Did you mean milligrams? (y/n) ', 's');
    if strcmp(meant, 'y')
        output = 'mg';
    else 
        return;
    end
elseif strcmp(units,' kilo grams') || strcmp(units,' kilo gram')
    trueOrFalse = true;
    meant = input('Did you mean kilograms? (y/n) ', 's');
    if strcmp(meant, 'y')
        output = 'kg';
    else 
        return;
    end
elseif strcmp(units,' milli meters') || strcmp(units,' milli meter')
    trueOrFalse = true;
    meant = input('Did you mean millimeters? (y/n) ', 's');
    if strcmp(meant, 'y')
        output = 'mm';
    else 
        return;
    end
elseif strcmp(units,' centi meters') || strcmp(units, ' centi meter')
    trueOrFalse = true;
    meant = input('Did you mean centimeters? (y/n) ', 's');
    if strcmp(meant, 'y')
        output = 'cm';
    else 
        return;
    end
elseif strcmp(units,' kilo meters') || strcmp(units,' kilo meter')
    trueOrFalse = true;
    meant = input('Did you mean kilometers? (y/n) ', 's');
    if strcmp(meant, 'y')
        output = 'km';
    else 
        return;
    end
elseif strcmp(units,' mm squared') || strcmp(units,' mm 2')
    trueOrFalse = true;
    meant = input('Did you mean mm^2? (y/n) ', 's');
    if strcmp(meant, 'y')
        output = 'mm^2';
    else 
        return;
    end
elseif strcmp(units,' cm squared') || strcmp(units,' cm 2')
    trueOrFalse = true;
    meant = input('Did you mean cm^2? (y/n) ', 's');
    if strcmp(meant, 'y')
        output = 'cm^2';
    else 
        return;
    end
elseif strcmp(units,' m squared') || strcmp(units,' m 2')
    trueOrFalse = true;
    meant = input('Did you mean m^2? (y/n) ', 's');
    if strcmp(meant, 'y')
        output = 'm^2';
    else 
        return;
    end
elseif strcmp(units,' km squared') || strcmp(units,' km 2')
    trueOrFalse = true;
    meant = input('Did you mean km^2? (y/n) ', 's');
    if strcmp(meant, 'y')
        output = 'km^2';
    else 
        return;
    end
elseif strcmp(units,' in squared') || strcmp(units,' in 2')
    trueOrFalse = true;
    meant = input('Did you mean in^2? (y/n) ', 's');
    if strcmp(meant, 'y')
        output = 'in^2';
    else 
        return;
    end
elseif strcmp(units, ' inches squared') || strcmp(units, ' inches 2')
    trueOrFalse = true;
    meant = input('Did you mean in^2? (y/n) ', 's');
    if strcmp(meant, 'y')
        output = 'in^2';
    else 
        return;
    end
elseif strcmp(units, ' feet squared') || strcmp(units, ' feet 2')
    trueOrFalse = true;
    meant = input('Did you mean ft^2? (y/n) ', 's');
    if strcmp(meant, 'y')
        output = 'ft^2';
    else 
        return;
    end
elseif strcmp(units, ' ft squared') || strcmp(units, ' ft 2')
    trueOrFalse = true;
    meant = input('Did you mean ft^2? (y/n) ', 's');
    if strcmp(meant, 'y')
        output = 'ft^2';
    else 
        return;
    end
elseif strcmp(units, ' miles squared') || strcmp(units, ' miles 2')
    trueOrFalse = true;
    meant = input('Did you mean mi^2? (y/n) ', 's');
    if strcmp(meant, 'y')
        output = 'mi^2';
    else 
        return;
    end
elseif strcmp(units, ' mi squared') || strcmp(units, ' mi 2')
    trueOrFalse = true;
    meant = input('Did you mean mi^2? (y/n) ', 's');
    if strcmp(meant, 'y')
        output = 'mi^2';
    else 
        return;
    end
elseif strcmp(units, ' acers') || strcmp(units, ' arces')
    trueOrFalse = true;
    meant = input('Did you mean acres? (y/n) ', 's');
    if strcmp(meant, 'y')
        output = 'ac';
    else 
        return;
    end
else 
    fprintf('No replacement suggestions for those units!\n');
    return;
end

end
