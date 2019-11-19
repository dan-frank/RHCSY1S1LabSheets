
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
    assert counts.get_total() == 3

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

if __name__ == "__main__":
    test_all()
