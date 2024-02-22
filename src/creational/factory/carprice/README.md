# FACTORY DESIGN PATTERN

#### Use case: Get Car Price
#### Author - <a href="https://www.linkedin.com/in/mohit-chaudhari-1018/">Mohit Chaudhari</a>
#### Date - 22nd Feb 2024

![Mohit Chaudhari - Factory Design Pattern - Get Car Price.png](utils%2FMohit%20Chaudhari%20-%20Factory%20Design%20Pattern%20-%20Get%20Car%20Price.png)

### Benefits:

<ul>
<li>Loose coupling: Client code doesn't depend on concrete product classes, making it easier to change implementations.</li>
<li>Flexibility: New products can be added without modifying existing code.</li>
<li>Testability: Easier to mock and test concrete products in isolation.</li>
</ul>

### Variations:

<ul>
<li>Static Factory Method: Creates products within the same class as the Product interface.</li>
<li>Abstract Factory: Creates families of related products.</li>
</ul>

### Usage of Factory Design Pattern
<ul>
<li>When a class doesn't know what sub-classes will be required to create</li>
<li>When a class wants that its sub-classes specify the objects to be created.</li>
<li>When the parent classes choose the creation of objects to its sub-classes.</li>
</ul>

