import matplotlib.pyplot as plt
import numpy as np
x = np.linspace(0,5)
plt.plot(x,100 * 2 ** x)
plt.grid(1)
plt.title("5) 100 * 2 ** x")
plt.show()

