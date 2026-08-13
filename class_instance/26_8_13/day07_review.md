1.
List<String> names = users.stream()
.filter(user -> user.getAge() >= 18)
.map(User::getUsername)
.sorted(Comparator.reverseOrder())
.toList();

List<User>
↓
Stream<User>
↓
Stream<User> (user.getAge>=18)
↓
Stream<name>
↓
Stream<name> 倒序
↓
List<String>

2. ACTIVE + 年龄≥18 → 用户名 → 用户名倒序 → List<String>
List<String> legalUsers = users.stream()
                .filter( user -> user.getAge() >= 18 && "ACTIVE".equals(user.getStatus))
                .map(User::getUsername())
                .sorted(Comparator.reverseOrder())
                .toList();

