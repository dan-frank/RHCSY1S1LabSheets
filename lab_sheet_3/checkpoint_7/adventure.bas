HasKey% = 0

PRINT "There is a small Russian doll on the table."
PRINT "You open it and find two more dolls, one blue and one green."

choose:
PRINT "There is a blue Russian doll and a green Russian doll on the table."
PRINT "1. Open blue doll"
PRINT "2. Open green doll"
INPUT "Enter a number:", Input%

IF Input%=1 THEN
  IF HasKey%=1 THEN
    GOTO haskey
  ELSE
    GOTO nokey
  END IF
ELSE IF Input%=2 THEN
  GOTO greendoll
ELSE
  PRINT "That is an incorrect value..."
  GOTO choose
END IF

greendoll:
PRINT "The doll contains a small key."
PRINT "You take the key."
HasKey% = 1
GOTO choose

nokey:
PRINT "You don't have a key to open the box."
PRINT "You put the box back and close the doll."
GOTO choose

haskey:
PRINT "The key unlocks the blue doll."
PRINT "Congratulations, you have found the golden token!"

PRINT ""
PRINT "For small programs the GOTO statements seem managable and even make writing code easier."
PRINT "However I can easily see it becoming confusing and annoying to navigate in large programmes."
PRINT "My codes structure seems a little confusing already."
PRINT "If I read it in sequence then it wouldn't make much sense as it looks like everything will just run even though some parts will be missed if a certain sequence of events take place."
PRINT "It's quite easy to run unintended pieces of code using GOTO's, and I did such developing this small programme."