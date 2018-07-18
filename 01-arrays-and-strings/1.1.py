import unittest


def is_unique_only(s):
    """
    :returns: true if the input string only contains unique characters
    """
    if s == None:
        return False

    characters = set()
    for x in s:
        characters.add(x)

    return len(characters) == len(s)


class Test(unittest.TestCase):
    true_cases = ['abcd', '1234', '']
    false_cases = ['dfadsf', '12341', None]

    def test_unique_true(self):
        for s in self.true_cases:
            self.assertTrue(is_unique_only(s))

    def test_unique_false(self):
        for s in self.false_cases:
            self.assertFalse(is_unique_only(s))


if __name__ == "__main__":
    unittest.main()
