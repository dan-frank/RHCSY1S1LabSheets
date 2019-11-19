class Person:
	def __init__(self, first_name, last_name, age, occupation):
		self.first_name = first_name
		self.last_name = last_name
		self.age = age
		self.occupation = occupation

	def grow(self):
		self.age += 1

	def fullName(self):
		full_name = self.first_name + " " + self.last_name
		return full_name

anna = Person("Anna", "Carp", 27, "Director")
peter = Person("Peter", "Williams", 34, "Developer")

print(anna.age)
anna.grow()
print(anna.age)

print(anna.fullName())
print(peter.fullName())