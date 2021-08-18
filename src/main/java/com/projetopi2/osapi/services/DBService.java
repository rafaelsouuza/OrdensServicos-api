package com.projetopi2.osapi.services;

import com.projetopi2.osapi.domain.Cliente;
import com.projetopi2.osapi.domain.OS;
import com.projetopi2.osapi.domain.Tecnico;
import com.projetopi2.osapi.domain.enuns.Prioridade;
import com.projetopi2.osapi.domain.enuns.Status;
import com.projetopi2.osapi.repositories.ClienteRepository;
import com.projetopi2.osapi.repositories.OSRepository;
import com.projetopi2.osapi.repositories.TecnicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private OSRepository osRepository;

    public void instanciaDB() {
        Tecnico t1 = new Tecnico(null, "Rafael Souza", "137.458.960-84","(61) 96675-6556");
        Tecnico t2 = new Tecnico(null, "Linus Torvalds", "138.876.030-44", "(61) 86943-9834");
        Cliente c1 = new Cliente(null, "Lucas Lima", "854.402.150-69", "(61) 96795-6554");
        OS os1 = new OS(null, Prioridade.ALTA, "Teste create OS", Status.ANDAMENTO, t1, c1);

        t1.getList().add(os1);
        c1.getList().add(os1);

        tecnicoRepository.saveAll(Arrays.asList(t1, t2));
        clienteRepository.saveAll(Arrays.asList(c1));
        osRepository.saveAll(Arrays.asList(os1));
    }
}
