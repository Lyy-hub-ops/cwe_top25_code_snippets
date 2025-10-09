# Safe Python code example
def safe_function(user_input):
    """Safely processes user input"""
    # Input validation
    if not isinstance(user_input, str):
        raise ValueError("Input must be a string")
    
    # Safe processing
    processed = user_input.strip().lower()
    return f"Processed: {processed}"

if __name__ == "__main__":
    result = safe_function("Hello World")
    print(result)
