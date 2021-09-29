package nl.miwgroningen.se6.vincent.librarydemo.service;

import nl.miwgroningen.se6.vincent.librarydemo.repository.LibraryUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Vincent Velthuizen <v.r.velthuizen@pl.hanze.nl>
 *
 * Makes library user details available to the system
 */

@Service
public class LibraryUserDetailsService implements UserDetailsService {

    LibraryUserRepository libraryUserRepository;

    public LibraryUserDetailsService(LibraryUserRepository libraryUserRepository) {
        this.libraryUserRepository = libraryUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return libraryUserRepository.findByUsername(s).orElseThrow(
                () -> new UsernameNotFoundException("User with name " + s + " was not found."));
    }
}
