package com.bastos.app.crudclient.dataprovider.mapper;

import com.bastos.app.crudclient.dataprovider.repository.entity.ClientEntity;
import com.bastos.app.crudclient.usecase.domain.response.ClientDomainResponse;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe responsável por converter os dados de saída de entidade no qual o banco de dados devolve,
 * para os dados de domínio da aplicação.
 *
 * @since 09/05/2021
 */
public class ClientDomainResponseMapper {

    public static List<ClientDomainResponse> convertEntityToDomain(List<ClientEntity> allClientsEntity) {
        return allClientsEntity.stream()
                .map(clientEntity -> ClientDomainResponse.builder()
                        .id(clientEntity.getId())
                        .name(clientEntity.getName())
                        .birthDate(clientEntity.getBirth())
                        .build())
                .collect(Collectors.toList());
    }

    public static ClientDomainResponse convertEntityToDomain(ClientEntity clientEntity) {
        return ClientDomainResponse.builder()
                .id(clientEntity.getId())
                .name(clientEntity.getName())
                .birthDate(clientEntity.getBirth())
                .build();
    }
}
