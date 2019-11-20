
from character_counter import CharacterCounter

def test_empty():
    counts = CharacterCounter("")
    assert counts.get_count('a') == 0
    assert counts.get_count('C') == 0
    assert counts.get_count('z') == 0

def test_single():
    counts = CharacterCounter("c")
    assert counts.get_count('c') == 1

def test_single_zero():
    counts = CharacterCounter("c")
    assert counts.get_count('d') == 0

def test_lower_in_upper_get():
    counts = CharacterCounter("f")
    assert counts.get_count('F') == 1

def test_upper_in_lower_get():
    counts = CharacterCounter("F")
    assert counts.get_count('f') == 1

def test_special():
    counts = CharacterCounter("a! b")
    assert counts.get_count('!') == 1

def test_total_empty():
    counts = CharacterCounter("")
    assert counts.get_total() == 0

def test_total_simple():
    counts = CharacterCounter("abC")
    assert counts.get_total() == 3

def test_total_special():
    counts = CharacterCounter("abc!")
    assert counts.get_total() == 4

def test_long_string():
    counts = CharacterCounter("Ringo would always say grammatically incorrect phrases and we’d all laugh. I remember when we were driving back to Liverpool from Luton up the M1 motorway in Ringo’s Zephyr, and the car’s bonnet hadn’t been latched properly. The wind got under it and blew it up in front of the windscreen. We were all shouting, ‘Aaaargh!’ and Ringo calmly said, ‘Don’t worry, I’ll soon have you back in your safely-beds’.")
    assert counts.get_total() == 315

def test_all():
    test_empty()
    test_single()
    test_single_zero()
    test_lower_in_upper_get()
    test_upper_in_lower_get()
    test_special()
    test_total_empty()
    test_total_simple()
    test_total_special()
    test_long_string()

if __name__ == "__main__":
    test_all()