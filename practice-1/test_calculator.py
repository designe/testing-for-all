import calculator

def test_increment():
    # given (expected_result)
    expected_result = 5
    
    # when (actual_result)
    actual_result = calculator.increment(4)
    
    # then (expected_result == actual_result)
    assert expected_result == actual_result
    
def test_decrement():
    # given
    expected_result = 5
    
    # when
    actual_result = calculator.decrement(6)
    
    # then
    assert expected_result== actual_result