import unittest
import random


def is_triangle(a, b, c):
    if a + b > c and b + c > a and c + a > b:
        return True
    return False

class TriangleTest(unittest.TestCase):
    def test_valid_triangle(self):
        self.assertTrue(is_triangle(3, 4, 5))
        self.assertTrue(is_triangle(5, 12, 13))
        self.assertTrue(is_triangle(8, 15, 17))

    def test_invalid_triangle(self):
        self.assertFalse(is_triangle(1, 1, 3))
        self.assertFalse(is_triangle(5, 10, 25))
        self.assertFalse(is_triangle(2, 7, 10))

    def test_zero_sides(self):
        self.assertFalse(is_triangle(0, 4, 5))
        self.assertFalse(is_triangle(3, 0, 5))
        self.assertFalse(is_triangle(3, 4, 0))

    def test_negative_sides(self):
        self.assertFalse(is_triangle(-3, 4, 5))
        self.assertFalse(is_triangle(3, -4, 5))
        self.assertFalse(is_triangle(3, 4, -5))

    def test_string_input(self):
        self.assertFalse(is_triangle("3", "4", "5"))

    def test_side_order(self):
        self.assertTrue(is_triangle(5, 3, 4))
        self.assertTrue(is_triangle(13, 5, 12))
        self.assertTrue(is_triangle(17, 8, 15))

    def test_side_order_invalid(self):
        self.assertFalse(is_triangle(1, 3, 1))
        self.assertFalse(is_triangle(10, 25, 5))
        self.assertFalse(is_triangle(7, 2, 10))

    def test_exception(self):
        with self.assertRaises(TypeError):
            is_triangle(3, 4, '5')

    def test_large_values(self):
        self.assertTrue(is_triangle(10 ** 9, 10 ** 9, 10 ** 9))
        self.assertFalse(is_triangle(10 ** 9, 10 ** 9, 2 * 10 ** 9 + 1))

    def test_decimal_values(self):
        self.assertTrue(is_triangle(0.5, 0.5, 0.7))
        self.assertFalse(is_triangle(0.1, 0.2, 0.5))

    def test_random_values(self):
        random.seed(42)  # Set a seed for reproducibility
        for _ in range(100):
            a = random.randint(1, 100)
            b = random.randint(1, 100)
            c = random.randint(1, 100)
            expected_result = a + b > c and b + c > a and c + a > b
            self.assertEqual(is_triangle(a, b, c), expected_result)

    def test_parameterized_values(self):
        test_cases = [
            (3, 4, 5, True),
            (1, 1, 3, False),
            (5, 10, 25, False),
            # ...
        ]
        for a, b, c, expected_result in test_cases:
            self.assertEqual(is_triangle(a, b, c), expected_result)
if __name__ == "__main__":
    unittest.main()