import math

# The standard gravitational parameter for the sun
mu = 1.327 * math.pow(10, 20)

class Planet:
	def __init__(self, name, radius, moon_num, orbital_radius):
		self.name = name
		self.radius = radius # in km
		self.moon_num = moon_num
		self.orbital_radius = orbital_radius

	def Moons(self):
		if self.moon_num == 1:
			moons = str(self.moon_num) + " moon"
		else:
			moons = str(self.moon_num) + " moons"
		return moons

	def Characteristics(self):
		print (self.name + " has a volume of " + str(volume(self)) + " cubic km, a surface area of " + str(surface(self)) + " sq. km, and " + self.Moons())

	def DaysInYear(self):
		period = 2 * math.pi * self.orbital_radius * math.sqrt(self.orbital_radius / mu)
		print (self.name + " has a year of approximately " + str(period // (60 * 60 * 24)) + " days")

	def Collide(self):
		self.moon_num += 1

def volume(planet):
	v = (4 / 3) * math.pi * math.pow(planet.radius, 3)
	return str(v)

def surface(planet):
	area = 4 * math.pi * math.pow(planet.radius, 2)
	return str(area)

earth = Planet("Earth", 6371, 1, (1.496 * math.pow(10, 11)))
jupiter = Planet("Jupiter", 69911, 79, (7.786 * math.pow(10, 11)))

earth.Characteristics()
earth.DaysInYear()
print()

jupiter.Characteristics()
jupiter.DaysInYear()
print()

print(jupiter.name + " has collided with another planet!")
jupiter.Collide()
print(jupiter.name + " now has " + jupiter.Moons())