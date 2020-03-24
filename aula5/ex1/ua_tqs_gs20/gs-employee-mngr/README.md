# Exercise 1
## a)
 - For example, on class `EmployeeRepositoryTest`:
 ```java
 class EmployeeRepositoryTest {
    ...
    @Test
    public void whenFindByName_thenReturnEmployee() {
       ...
       assertThat(found.getName()).isEqualTo(alex.getName());
    }

    @Test
    public void whenFindById_thenReturnEmployee() {
        ...
        assertThat(fromDb.getName()).isEqualTo(emp.getName());
    }
}
```

## b) 
 - For example, on class `EmployeeControlerIT`:
 ```java
class EmployeeControlerIT {
    ...
    @Test
    public void whenPostEmployee_thenCreateEmployee() throws Exception {
        Employee alex = new Employee("alex");
        given(service.save(Mockito.any())).willReturn(alex);
    
        mvc.perform(post("/api/employees").contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toJson(alex))).andExpect(status().isCreated()).andExpect(jsonPath("$.name", is("alex")));
        verify(service, VerificationModeFactory.times(1)).save(Mockito.any());
        reset(service);
    }
}
```

## c)
 - `@Mock` allows to mock a class or an interface and to record and verify behaviors on it
 - `@MockBean` allows to add Mockito mocks in a Spring ApplicationContext. If a bean, compatible with the declared class exists in the context, it replaces it by the mock. If it is not the case, it adds the mock in the context as a bean.

## d)
 - The file `application-integrationtest.properties` is used to override the Springboot application properties.
 - In this case, the defined properties are to connect to a database with the user `demo` and password `demo` and to drop the database when the application finishes. This is very usual in test scenarios, when we want to add some mock data to a database, when we finish testing, all the data added to the test database during tests is dropped.
 - This properties are used when we have a class with the annotation:
 ```java
@TestPropertySource(locations = "application-integrationtest.properties")
```
