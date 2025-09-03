package com.example.myapplication;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import com.example.myapplication.databinding.FragmentLoginBinding; // IMPORTANT: Regenerate if you renamed XML

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding; // Use FragmentLoginBinding

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (binding.buttonLogin != null) {
            binding.buttonLogin.setOnClickListener(v -> {
                performLogin();
            });
        } else {
            Log.e("LoginFragment", "Login button is null. Check layout ID.");
            if (getContext() != null) {
                Toast.makeText(getContext(), "Error: Login button not found.", Toast.LENGTH_SHORT).show();
            }
        }

        if (binding.textGoToSignup != null) {
            binding.textGoToSignup.setOnClickListener(v -> {
                // Navigate to SignupFragment
                try {
                    NavController navController = NavHostFragment.findNavController(LoginFragment.this);
                    navController.navigate(R.id.action_LoginFragment_to_SignupFragment);
                } catch (Exception e) {
                    Log.e("LoginFragment", "Error navigating to signup", e);
                    if (getContext() != null) {
                        Toast.makeText(getContext(), "Error navigating back.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        // Back button click listener
        if (binding.buttonBack != null) {
            binding.buttonBack.setOnClickListener(v -> {
                try {
                    NavController navController = NavHostFragment.findNavController(LoginFragment.this);
                    navController.navigate(R.id.action_LoginFragment_to_LandingFragment);
                } catch (Exception e) {
                    Log.e("LoginFragment", "Error navigating back to welcome", e);
                    if (getContext() != null) {
                        Toast.makeText(getContext(), "Error navigating back.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void performLogin() {
        String email = "";
        if (binding.editTextEmail != null && binding.editTextEmail.getText() != null) {
            email = binding.editTextEmail.getText().toString().trim();
        }

        String password = "";
        if (binding.editTextPassword != null && binding.editTextPassword.getText() != null) {
            password = binding.editTextPassword.getText().toString().trim();
        }

        if (TextUtils.isEmpty(email)) {
            binding.textFieldEmail.setError("Email is required");
            // Or if using editText directly: binding.editTextEmail.setError("Email is required");
            return;
        } else {
            binding.textFieldEmail.setError(null);
        }

        if (TextUtils.isEmpty(password)) {
            binding.textFieldPassword.setError("Password is required");
            // Or: binding.editTextPassword.setError("Password is required");
            return;
        } else {
            binding.textFieldPassword.setError(null);
        }

        // --- SIMULATED LOGIN ---
        // In a real app, you would authenticate against a backend or Firebase, etc.
        // For this example, let's assume a hardcoded successful login
        Log.d("LoginFragment", "Attempting login with Email: " + email + ", Password: " + password);

        if (email.equals("test@example.com") && password.equals("password123")) {
            if (getContext() != null) {
                Toast.makeText(getContext(), "Login Successful!", Toast.LENGTH_SHORT).show();
            }
            Log.i("LoginFragment", "Login successful for " + email);
            // Navigate back to FirstFragment after successful login
            try {
                NavController navController = NavHostFragment.findNavController(LoginFragment.this);
                navController.navigate(R.id.action_LoginFragment_to_FirstFragment);
            } catch (Exception e) {
                Log.e("LoginFragment", "Navigation after login failed", e);
                if (getContext() != null) {
                    Toast.makeText(getContext(), "Error navigating after login.", Toast.LENGTH_SHORT).show();
                }
            }
        } else {
            if (getContext() != null) {
                Toast.makeText(getContext(), "Invalid email or password.", Toast.LENGTH_SHORT).show();
            }
            Log.w("LoginFragment", "Login failed for " + email);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // Important to avoid memory leaks
    }
}
