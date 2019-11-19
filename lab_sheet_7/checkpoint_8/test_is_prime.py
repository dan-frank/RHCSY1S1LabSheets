
from is_prime import is_prime

def test_simple_prime():
    assert is_prime(7)

# Add new test methods here

def test_all():
    test_simple_prime()
    # Call new test here

if __name__ == "__main__":
    test_all()
