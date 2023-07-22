# ComplexCalculator
Это простой калькулятор комплексных чисел, который может складывать, вычитать, умножать и делить.
## Синтаксис
### Как записываются комплексные числа ?
Комплексные числа записываются в следующем формате **a + bi** или **a - bi**

Где, a - вещественная часть,
    b - мнимую часть

Если b < 0, и вы написали **a - bi**, тогда мнимая часть будет интерпретироваться как положительная.
Например: _2 - -2i_, тоже самое что и _2 + 2i_

Если b > 0 и вы записали число через разность, то мнимая часть будет интерпретироваться как отрицательная. 
Например: _2 - 2i_, тоже самое что и _2 + -2i_

Дробные числа записываются через точку.

Некоторые примеры валидных записей:
* 2.323 + 2i
* 0.323 - 2i
* 0.23 + -2i
* 2 + 2i
* 0 + 0i
* 2.3 + 2.3434i
### Какие есть операции?
#### На данный момент существует всего четыре доступных операции:
* ADD - сложение
* MUL - умножение
* DIV - деление
* SUB - вычитание
### Как записывать выражения ?
#### Синтаксис выражений следующий:

**_operand1_ _operation_ _operand2_**, где:
* _operand1_ - первое комплексное число для операции
* _operation_ - вышеописанная операция
* _operand2_ -  второе комплексное число для операции
#### Некоторые примеры валидных выражений:
* **_2 + 2i_ SUB _2 - 2i_**
* **_20 + 3i_ ADD _2 - 2.0i_**
* **_20 + 3i_ MUL _2 - 2.0i_**
* **_2 + 2i_ DIV _2 - 2.0i_**
