fileTurtle = open("turtle.txt","w")

turtleSpeed = 200
turtlePen   = 10

intialVariables = "speed {}\n".format(turtleSpeed) + "pen violet, {}\n".format(turtlePen) + "rt 180\n" + "fd 100\n" + "rt -90\n" + "fd 50\n" + "rt -90\n" + "fd 100\n"
firstLoop = "rt 90\n" + "fd 25\n" + "rt 90\n" + "fd 125\n" + "rt 90\n" + "fd 100\n" + "rt 90\n" + "fd 150\n" + "rt 90\n" + "fd 25\n"

linePath           = ""
lineCount          = 20

lineVertical       = 150
lineHorizontal     = 100
lineTopVertical    = 25
lineTopHorizontal  = 25
lineRotate         = -90

# add 50
# minus 25
# add 50
# add 25

i = 0
while i < lineCount:

	lineVertical            += 50
	lineHorizontal          += 50
	lineTopHorizontal       += 25

	actionRotate        = "rt {}\n".format(lineRotate)

	actionTopVertical   = "fd {}\n".format(lineTopVertical)
	actionTopHorizontal = "fd {}\n".format(lineTopHorizontal)

	actionVertical      = "fd {}\n".format(lineVertical)
	actionHorizontal    = "fd {}\n".format(lineHorizontal)

	linePath = linePath + actionRotate + actionTopVertical + actionRotate + actionTopHorizontal + actionRotate + actionVertical + actionRotate + actionHorizontal

	if i % 2 == 0:
		lineVertical -= 25
	# else:
	# 	lineVertical += 25

	actionVertical      = "fd {}\n".format(lineHorizontal)

	lineRotate = lineRotate * -1

	linePath = linePath + actionRotate + actionVertical + actionRotate + actionTopHorizontal

	i += 1

completeLoop = intialVariables + firstLoop

fileTurtle.write(completeLoop) 
fileTurtle.writelines(linePath)
fileTurtle.close()
