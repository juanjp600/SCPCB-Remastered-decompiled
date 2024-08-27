Function checktriggers$()
    Local local0%
    Local local1#
    Local local2#
    Local local3#
    Local local4%
    local4 = $FFFFFFFF
    If (playerroom\Field36 = $00) Then
        Return ""
    Else
        For local0 = $00 To (playerroom\Field36 - $01) Step $01
            entityalpha(playerroom\Field37[local0], 1.0)
            local1 = entityscalex(playerroom\Field37[local0], $01)
            local2 = max(entityscaley(playerroom\Field37[local0], $01), 0.001)
            local3 = entityscalez(playerroom\Field37[local0], $01)
            getmeshextents(playerroom\Field37[local0])
            If (debughud <> 0) Then
                entitycolor(playerroom\Field37[local0], 255.0, 255.0, 0.0)
                entityalpha(playerroom\Field37[local0], 0.2)
            Else
                entitycolor(playerroom\Field37[local0], 255.0, 255.0, 255.0)
                entityalpha(playerroom\Field37[local0], 0.0)
            EndIf
            If (((entityx(collider, $00) > ((local1 * mesh_minx) + playerroom\Field3)) And (entityx(collider, $00) < ((local1 * mesh_maxx) + playerroom\Field3))) <> 0) Then
                If (((entityy(collider, $00) > ((local2 * mesh_miny) + playerroom\Field4)) And (entityy(collider, $00) < ((local2 * mesh_maxy) + playerroom\Field4))) <> 0) Then
                    If (((entityz(collider, $00) > ((local3 * mesh_minz) + playerroom\Field5)) And (entityz(collider, $00) < ((local3 * mesh_maxz) + playerroom\Field5))) <> 0) Then
                        local4 = local0
                        Exit
                    EndIf
                EndIf
            EndIf
        Next
        If (local4 > $FFFFFFFF) Then
            Return playerroom\Field38[local4]
        EndIf
    EndIf
    Return ""
End Function
