# Note: this implementation is over-complicated. This is because we want
# it to have bugs!

# Some useful constants
A_NUM = ord('a')
Z_NUM = ord('z')
A_UPPER_NUM = ord('A')
Z_UPPER_NUM = ord('Z')
LOWER_DIFF = ord('a') - ord('A') + 1

class CharacterCounter:
    def __init__(self, text):
        """Count letter occurrences in text and build an object storing
        the results. Counts a-z characters only and is case insensitive.
        :param text: a string of text whose characters are to be counted"""

        # initialize a-z counts to 0
        self.counts = { }
        for c in range(A_NUM, Z_NUM):
            self.counts[chr(c)] = 0

        for c in text:
            c_lower = self._to_lower(c)
            c_number = ord(c_lower)

            if (c_number >= A_NUM and c_number <= Z_NUM):
                self.counts[chr(c_number)] += 1

    def get_count(self, c):
        """Get the number of occurences of character c or return None if
        the character is out of range.a-z or A-Z. Counts are case
        insensitive.
        :param c: the character to count"""
        c_lower = self._to_lower(c)
        c_number = ord(c_lower)

        if c_number >= A_NUM and c_number < Z_NUM:
            return self.counts[c_lower]

        return None

    def get_total(self):
        """Calculate he total number of characters counted
        :returns: the integer number of counted characters"""
        total = 0

        for c in self.counts:
            total += self.counts[c]

        return total

    def _to_lower(self, c):
        """Convert a character to lower case
        :param c: the character to convert
        :returns: c in lower case, or unchanged if it is not A-Z"""
        c_number = ord(c)

        # if A-Z, change to a-z
        if (c_number >= A_UPPER_NUM and c_number < Z_UPPER_NUM):
            return chr(c_number + LOWER_DIFF)

        return c



