def multiplicar(self, a, b):
        """Multiplica dos números"""
        self.validar_numeros(a, b)
        logger.info("Multiplicando {%a} * {%b}")
        return a * b
    
    
    
    
    
print(multiplicar(1, 2,5))