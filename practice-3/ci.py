from typing import List

def ci95(samples: List[int]):
    n = len(samples)
    sum = 0
    sum_square = 0
    for item in samples:
        sum = sum + item
        sum_square = sum_square + (item ** 2)
    avg = sum / n
    avg_square = (avg ** 2) # E(X) ^ 2
    avg_sum_square = sum_square / n
    # var (분산) = E(X^2) - E(X)^2
    var = avg_sum_square - avg_square
    std = var ** 0.5
    
    ci_min = avg - (1.96 * (std / (n ** 0.5)))
    ci_max = avg + (1.96 * (std / (n ** 0.5)))
        
    return ci_min, ci_max