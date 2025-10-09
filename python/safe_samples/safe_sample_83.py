# Safe file handling
import os
from pathlib import Path

def safe_file_read(filename):
    """Safely read a file with proper validation"""
    # Validate filename
    safe_path = Path(filename).resolve()
    
    # Check if file exists and is readable
    if not safe_path.exists():
        raise FileNotFoundError(f"File not found: {filename}")
    
    if not safe_path.is_file():
        raise ValueError(f"Path is not a file: {filename}")
    
    # Safe read
    with open(safe_path, 'r', encoding='utf-8') as f:
        return f.read()
