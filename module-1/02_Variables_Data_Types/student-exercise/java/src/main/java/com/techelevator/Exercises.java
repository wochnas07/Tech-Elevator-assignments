package com.techelevator;

public class Exercises {

	public static void main(String[] args) {

        /*
        1. 4 birds are sitting on a branch. 1 flies away. How many birds are left on
        the branch?
        */

		// ### EXAMPLE:
		int initialNumberOfBirds = 4;
		int birdsThatFlewAway = 1;
		int remainingNumberOfBirds = initialNumberOfBirds - birdsThatFlewAway;
        /*
        2. There are 6 birds and 3 nests. How many more birds are there than
        nests?
        */

		// ### EXAMPLE:
		int numberOfBirds = 6;
		int numberOfNests = 3;
		int numberOfExtraBirds = numberOfBirds - numberOfNests;

        /*
        3. 3 raccoons are playing in the woods. 2 go home to eat dinner. How
        many raccoons are left in the woods?
        */
		int numberOfRaccoons = 3;
		int raccoonsEatingDinner = 2;
		int remainingRaccoons = numberOfRaccoons - raccoonsEatingDinner;
		System.out.println("Raccoons left in the woods: " + remainingRaccoons);
        /*
        4. There are 5 flowers and 3 bees. How many less bees than flowers?
        */
		int flowers = 5;
		int bees = 3;
		int moreFlowers = flowers - bees;
		System.out.println("Less bees than flowers: " + moreFlowers);
        /*
        5. 1 lonely pigeon was eating breadcrumbs. Another pigeon came to eat
        breadcrumbs, too. How many pigeons are eating breadcrumbs now?
        */
		int firstPigeon = 1;
		int otherPigeons = 1;
		int allPigeons = firstPigeon + otherPigeons;
		System.out.println("Pigeons eating breadcrumbs: " + allPigeons);
        /*
        6. 3 owls were sitting on the fence. 2 more owls joined them. How many
        owls are on the fence now?
        */
		int firstOwls = 3;
		int otherOwls = 2;
		int allOwls = firstOwls + otherOwls;
		System.out.println("Owls on the fence: " + allOwls);
        /*
        7. 2 beavers were working on their home. 1 went for a swim. How many
        beavers are still working on their home?
        */
		int workingBeavers = 2;
		int swimmingBeavers = 1;
		int beaversAtHome = workingBeavers - swimmingBeavers;
		System.out.println("Beavers still working: " + beaversAtHome);
        /*
        8. 2 toucans are sitting on a tree limb. 1 more toucan joins them. How
        many toucans in all?
        */
		int firstToucans = 2;
		int otherToucans = 1;
		int totalToucans = firstToucans + otherToucans;
		System.out.println("Total toucans: " + totalToucans);
        /*
        9. There are 4 squirrels in a tree with 2 nuts. How many more squirrels
        are there than nuts?
        */
		int squirrels = 4;
		int nuts = 2;
		int moreSquirrels = squirrels - nuts;
		System.out.println("More squirrels than nuts: " + moreSquirrels);
        /*
        10. Mrs. Hilt found a quarter, 1 dime, and 2 nickels. How much money did
        she find?
        */
		int quarters = 25;
		int dimes = 10;
		int nickels = 2 * 5;
		int totalMoney = quarters + dimes + nickels;
		System.out.println("Total Money: " + totalMoney + " cents");
        /*
        11. Mrs. Hilt's favorite first grade classes are baking muffins. Mrs. Brier's
        class bakes 18 muffins, Mrs. MacAdams's class bakes 20 muffins, and
        Mrs. Flannery's class bakes 17 muffins. How many muffins does first
        grade bake in all?
        */
		int brier = 18;
		int macadams = 20;
		int flannery = 17;
		int firstGrade = brier + macadams + flannery;
		System.out.println("Total muffins: " + firstGrade);
        /*
        12. Mrs. Hilt bought a yoyo for 24 cents and a whistle for 14 cents. How
        much did she spend in all for the two toys?
        */
		int yoyo = 24;
		int whistle = 14;
		int totalSpent = yoyo + whistle;
		System.out.println("Total spent: " + totalSpent);
        /*
        13. Mrs. Hilt made 5 Rice Krispie Treats. She used 8 large marshmallows
        and 10 mini marshmallows.How many marshmallows did she use
        altogether?
        */
		int largeMarshmallows = 8;
		int miniMarshmallows = 10;
		int totalMarshmallows = largeMarshmallows + miniMarshmallows;
		System.out.println("Total marshmallows: " + totalMarshmallows);
        /*
        14. At Mrs. Hilt's house, there was 29 inches of snow, and Brecknock
        Elementary School received 17 inches of snow. How much more snow
        did Mrs. Hilt's house have?
        */
		int hiltHouse = 29;
		int brecknockSchool = 17;
		int moreSnow = hiltHouse - brecknockSchool;
		System.out.println("More snow: " + moreSnow + " inches");
        /*
        15. Mrs. Hilt has $10. She spends $3 on a toy truck and $2 on a pencil
        case. How much money does she have left?
        */
		int originalMoney = 10;
		int toyTruck = 3;
		int pencilCase = 2;
		int moneyLeft = originalMoney - toyTruck - pencilCase;
		System.out.println("Money left: $" + moneyLeft);
        /*
        16. Josh had 16 marbles in his collection. He lost 7 marbles. How many
        marbles does he have now?
        */
		int initialMarbles = 16;
		int marblesLost = 7;
		int marblesLeft = initialMarbles - marblesLost;
		System.out.println("Marbles left: " + marblesLeft);
        /*
        17. Megan has 19 seashells. How many more seashells does she need to
        find to have 25 seashells in her collection?
        */
		int initialSeashells = 19;
		int totalSeashells = 25;
		int moreSeashells = totalSeashells - initialSeashells;
		System.out.println("Megan needs " + moreSeashells + " more seashells.");
        /*
        18. Brad has 17 balloons. 8 balloons are red and the rest are green. How
        many green balloons does Brad have?
        */
		int totalBalloons = 17;
		int redBalloons = 8;
		int greenBalloons = totalBalloons - redBalloons;
		System.out.println("Green balloons: " + greenBalloons);
        /*
        19. There are 38 books on the shelf. Marta put 10 more books on the shelf.
        How many books are on the shelf now?
        */
		int initialBooks = 38;
		int addedBooks = 10;
		int totalBooks = initialBooks + addedBooks;
		System.out.println("Total books: " + totalBooks);
        /*
        20. A bee has 6 legs. How many legs do 8 bees have?
        */
		int beeLegs = 6;
		int totalBees = 8;
		int totalBeeLegs = beeLegs * totalBees;
		System.out.println("Total legs: " + totalBeeLegs);
        /*
        21. Mrs. Hilt bought an ice cream cone for 99 cents. How much would 2 ice
        cream cones cost?
        */
		double coneCost = 0.99;
		int numberOfCones = 2;
		double totalCost = coneCost * numberOfCones;
		System.out.println("Total Cost: $" + totalCost);
        /*
        22. Mrs. Hilt wants to make a border around her garden. She needs 125
        rocks to complete the border. She has 64 rocks. How many more rocks
        does she need to complete the border?
        */
		int totalRocks = 125;
		int rocksOwned = 64;
		int rocksNeeded = totalRocks - rocksOwned;
		System.out.println("Rocks needed: " + rocksNeeded);
        /*
        23. Mrs. Hilt had 38 marbles. She lost 15 of them. How many marbles does
        she have left?
        */
		int hiltMarbles = 38;
		int lostMarbles = 15;
		int hiltMarblesLeft = hiltMarbles - lostMarbles;
		System.out.println("Marbles left: " + hiltMarblesLeft);
        /*
        24. Mrs. Hilt and her sister drove to a concert 78 miles away. They drove 32
        miles and then stopped for gas. How many miles did they have left to drive?
        */
		int totalMiles = 78;
		int firstHalf = 32;
		int secondHalf = totalMiles - firstHalf;
		System.out.println("Miles left: " + secondHalf);
        /*
        25. Mrs. Hilt spent 1 hour and 30 minutes shoveling snow on Saturday
        morning and 45 minutes shoveling snow on Saturday afternoon. How
        much total time did she spend shoveling snow?
        */
		int morningShoveling = 90;
		int afternoonShoveling = 45;
		int totalShoveling = morningShoveling + afternoonShoveling;
		System.out.println("Total time shoveling: " + totalShoveling + " minutes");
        /*
        26. Mrs. Hilt bought 6 hot dogs. Each hot dog cost 50 cents. How much
        money did she pay for all of the hot dogs?
        */
		int totalHotDogs = 6;
		double costHotDogs = 0.50;
		double totalCostHotDogs = totalHotDogs * costHotDogs;
		System.out.println("Total Cost: $" + totalCostHotDogs);
        /*
        27. Mrs. Hilt has 50 cents. A pencil costs 7 cents. How many pencils can
        she buy with the money she has?
        */
		int hiltsMoney = 50;
		int pencilCost = 7;
		int numberOfPencils = hiltsMoney / pencilCost;
		System.out.println("Pencils: " + numberOfPencils);
		
        /*
        28. Mrs. Hilt saw 33 butterflies. Some of the butterflies were red and others
        were orange. If 20 of the butterflies were orange, how many of them
        were red?
        */
		int totalButterflies = 33;
		int orangeButterflies = 20;
		int redButterflies = totalButterflies - orangeButterflies;
		System.out.println("Red butterflies: " + redButterflies);
        /*
        29. Kate gave the clerk $1.00. Her candy cost 54 cents. How much change
        should Kate get back?
        */
		int kateMoney = 100;
		int candyCost = 54;
		int kateChange = kateMoney - candyCost;
		System.out.println("Kate's change: " + kateChange + " cents");
        /*
        30. Mark has 13 trees in his backyard. If he plants 12 more, how many trees
        will he have?
        */
		int initialTrees = 13;
		int moreTrees = 12;
		int totalTrees = initialTrees + moreTrees;
		System.out.println("Total trees: " + totalTrees);
        /*
        31. Joy will see her grandma in two days. How many hours until she sees
        her?
        */
		int numberOfDays = 2;
		int hoursADay = 24;
		int totalHours = numberOfDays * hoursADay;
		System.out.println("Total hours: " + totalHours);
        /*
        32. Kim has 4 cousins. She wants to give each one 5 pieces of gum. How
        much gum will she need?
        */
		int kimsCousins = 4;
		int cousinsGum = 5;
		int totalGum = kimsCousins * cousinsGum;
		System.out.println("Gum needed: " + totalGum +" pieces");
        /*
        33. Dan has $3.00. He bought a candy bar for $1.00. How much money is
        left?
        */
		int danInitialMoney = 3;
		int costCandyBar = 1;
		int dansMoney = danInitialMoney - costCandyBar;
		System.out.println("Money left: $" + dansMoney);
        /*
        34. 5 boats are in the lake. Each boat has 3 people. How many people are
        on boats in the lake?
        */
		int boatsOnLake = 5;
		int boatCapacity = 3;
		int peopleOnLake = boatsOnLake * boatCapacity;
		System.out.println("People on boats in the lake: " + peopleOnLake);
        /*
        35. Ellen had 380 legos, but she lost 57 of them. How many legos does she
        have now?
        */
		int beginningLegos = 380;
		int lostLegos = 57;
		int endLegos = beginningLegos - lostLegos;
		System.out.println("Legos left: " + endLegos);
        /*
        36. Arthur baked 35 muffins. How many more muffins does Arthur have to
        bake to have 83 muffins?
        */
		int firstBaked = 35;
		int totalBaked = 83;
		int neededBaked = totalBaked - firstBaked;
		System.out.println("Arthur needs to bake " + neededBaked + " more muffins");
        /*
        37. Willy has 1400 crayons. Lucy has 290 crayons. How many more
        crayons does Willy have then Lucy?
        */
		int willyCrayons = 1400;
		int lucyCrayons = 290;
		int moreCrayons = willyCrayons - lucyCrayons;
		System.out.println("Willy has " + moreCrayons + " more crayons than Lucy.");
        /*
        38. There are 10 stickers on a page. If you have 22 pages of stickers, how
        many stickers do you have?
        */
		int stickersPerPage = 10;
		int totalPages = 22;
		int totalStickers = stickersPerPage * totalPages;
		System.out.println("Total stickers: " + totalStickers);
        /*
        39. There are 96 cupcakes for 8 children to share. How much will each
        person get if they share the cupcakes equally?
        */
		int totalCupcakes = 96;
		int totalChildren = 8;
		int cupcakesPerChild = totalCupcakes / totalChildren;
		System.out.println("Cupcakes per child: " + cupcakesPerChild);
        /*
        40. She made 47 gingerbread cookies which she will distribute equally in
        tiny glass jars. If each jar is to contain six cookies each, how many
        cookies will not be placed in a jar?
        */
		int totalGingerbread = 47;
		int gingerbreadPerJar = 6;
		int extraGingerbread = totalGingerbread % gingerbreadPerJar;
		System.out.println("Extra cookies: " + extraGingerbread);
        /*
        41. She also prepared 59 croissants which she plans to give to her 8
        neighbors. If each neighbor received and equal number of croissants,
        how many will be left with Marian?
        */
		int totalCroissants = 59;
		int numberOfNeighbors = 8;
		int mariansCroissants = totalCroissants % numberOfNeighbors;
		System.out.println("Croissants left with Marian: " + mariansCroissants);
        /*
        42. Marian also baked oatmeal cookies for her classmates. If she can
        place 12 cookies on a tray at a time, how many trays will she need to
        prepare 276 oatmeal cookies at a time?
        */
		int cookiesPerTray = 12;
		int totalCookies = 276;
		int totalTrays = totalCookies / cookiesPerTray;
		System.out.println("Total trays: " + totalTrays);
        /*
        43. Marian’s friends were coming over that afternoon so she made 480
        bite-sized pretzels. If one serving is equal to 12 pretzels, how many
        servings of bite-sized pretzels was Marian able to prepare?
        */
		int totalPretzels = 480;
		int pretzelServingSize = 12;
		int totalServings = totalPretzels / pretzelServingSize;
		System.out.println("Servings: " + totalServings);
        /*
        44. Lastly, she baked 53 lemon cupcakes for the children living in the city
        orphanage. If two lemon cupcakes were left at home, how many
        boxes with 3 lemon cupcakes each were given away?
        */
		int totalLemonCupcakes = 53;
		int leftAtHome = 2;
		int cupcakesPerBox = 3;
		int totalBoxes = (totalLemonCupcakes - leftAtHome) / cupcakesPerBox;
		System.out.println("Total boxes given away: " + totalBoxes);
        /*
        45. Susie's mom prepared 74 carrot sticks for breakfast. If the carrots
        were served equally to 12 people, how many carrot sticks were left
        uneaten?
        */
		int totalCarrotSticks = 74;
		int totalPeople = 12;
		int carrotsLeftover = totalCarrotSticks % totalPeople;
		System.out.println("Carrot sticks left uneaten: " + carrotsLeftover);
        /*
        46. Susie and her sister gathered all 98 of their teddy bears and placed
        them on the shelves in their bedroom. If every shelf can carry a
        maximum of 7 teddy bears, how many shelves will be filled?
        */
		int totalTeddyBears = 98;
		int bearsPerShelf = 7;
		int totalShelves = totalTeddyBears / bearsPerShelf;
		System.out.println("Total shelves filled: " + totalShelves);
        /*
        47. Susie’s mother collected all family pictures and wanted to place all of
        them in an album. If an album can contain 20 pictures, how many
        albums will she need if there are 480 pictures?
        */
		int picturesPerAlbum = 20;
		int totalPictures = 480;
		int totalAlbums = totalPictures / picturesPerAlbum;
		System.out.println("Albums needed: " + totalAlbums);
        /*
        48. Joe, Susie’s brother, collected all 94 trading cards scattered in his
        room and placed them in boxes. If a full box can hold a maximum of 8
        cards, how many boxes were filled and how many cards are there in
        the unfilled box?
        */
		int totalTradingCards = 94;
		int cardsPerBox = 8;
		int totalBoxesFilled = totalTradingCards / cardsPerBox;
		int cardsLeftover = totalTradingCards % cardsPerBox;
		System.out.println(totalBoxesFilled + " total boxes were filled, with " + cardsLeftover + " in the unfilled box.");
        /*
        49. Susie’s father repaired the bookshelves in the reading room. If he has
        210 books to be distributed equally on the 10 shelves he repaired,
        how many books will each shelf contain?
        */
		int totalFathersBooks = 210;
		int repairedShelves = 10;
		int booksPerShelf = totalFathersBooks / repairedShelves;
		System.out.println("Books per shelf: " + booksPerShelf);
        /*
        50. Cristina baked 17 croissants. If she planned to serve this equally to
        her seven guests, how many will each have?
        */
		int cristinaCroissants = 17;
		int numberOfGuests = 7;
		int croissantsPerGuest = cristinaCroissants / numberOfGuests;
		System.out.println("Croissants per guest: " + croissantsPerGuest);
        /*
            CHALLENGE PROBLEMS
        */

        /*
        Bill and Jill are house painters. Bill can paint a 12 x 14 room in 2.15 hours, while Jill averages
        1.90 hours. How long will it take the two painter working together to paint 5 12 x 14 rooms?
        Hint: Calculate the hourly rate for each painter, combine them, and then divide the total walls in feet by the combined hourly rate of the painters.
        Challenge: How many days will it take the pair to paint 623 rooms assuming they work 8 hours a day?.
        */
		int roomSize = 12 + 12 + 14 + 14;
		double billsAverage = roomSize / 2.15;
		double jillsAverage = roomSize / 1.90;
		double togetherAverage = billsAverage + jillsAverage;
		double combinedHourlyRate = roomSize / togetherAverage;
		double fiveRooms = combinedHourlyRate * 5;
		System.out.println("It will take Bill and Jill " + fiveRooms + " hours to paint 5 rooms.");
		int numberOfRooms = 623;
		double roomsPerDay = 8 / combinedHourlyRate;
		double daysWillTake = numberOfRooms / roomsPerDay;
		System.out.println("It will take " + daysWillTake + " days to paint 623 rooms.");

        /*
        Create and assign variables to hold your first name, last name, and middle initial. Using concatenation,
        build an additional variable to hold your full name in the order of last name, first name, middle initial. The
        last and first names should be separated by a comma followed by a space, and the middle initial must end
        with a period.
        Example: "Hopper, Grace B."
        */
		String firstName = "Sammi ";
		String lastName = "Wochna, ";
		String middleInitial = "M.";
		String fullName = lastName + firstName + middleInitial;
		System.out.println(fullName);
		
        /*
        The distance between New York and Chicago is 800 miles, and the train has already travelled 537 miles.
        What percentage of the trip has been completed?
        Hint: The percent completed is the miles already travelled divided by the total miles.
        Challenge: Display as an integer value between 0 and 100 using casts.
        */
		int totalDistance= 800;
		int distanceComplete = 537;
		int pctComplete = ((distanceComplete*100)/totalDistance);
		System.out.println("Percent Traveled: " + pctComplete + "%");

	}

}
