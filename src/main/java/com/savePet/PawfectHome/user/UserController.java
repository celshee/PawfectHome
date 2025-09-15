    package com.savePet.PawfectHome.user;
    import jakarta.validation.Valid;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;


    @RestController
    @RequestMapping("/users")
    public class UserController {

        private final UserService service;

        public UserController(UserService service){
            this.service=service;
        }

        @PostMapping("/register") //working
        public  ResponseEntity<UserResponseDTO> signUp(@Valid @RequestBody UserRequestDTO request) {
            System.out.println(request.toString());
            return  ResponseEntity.ok(service.registerUser(request));
        }

        @PostMapping("/login")
        public ResponseEntity<?> login(@RequestBody LoginRequestDTO request) {
            String token = service.login(request.getEmail(), request.getPassword());
            return ResponseEntity.ok(token);
        }
        @GetMapping()
        public ResponseEntity<List<UserResponseDTO>> listUsers() {
            return ResponseEntity.ok(service.getAllUsers());
        }
        @GetMapping("/{id}")
        public ResponseEntity<UserResponseDTO> getUser(@PathVariable int id) {
            return ResponseEntity.ok(service.getUser(id));
        }

        @PutMapping("/{id}") // check for empty spaces
        public  ResponseEntity<UserResponseDTO> updateUsers( @PathVariable int id, @RequestBody UserRequestDTO dto) {
            return ResponseEntity.ok(service.updateUser(id,dto));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteUser(@PathVariable int id) {
            service.deleteUser(id);
            return ResponseEntity.noContent().build(); // ⚡ best practice
        }



    }


