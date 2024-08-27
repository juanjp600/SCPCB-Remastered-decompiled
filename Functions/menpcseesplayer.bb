Function menpcseesplayer%(arg0.npcs, arg1%)
    If (chs\Field2 <> 0) Then
        Return $00
    EndIf
    If (((playerdetected = $00) Or ((arg0\Field5 <> $14) Or (arg0\Field5 <> $1C))) <> 0) Then
        If (0.0 >= arg0\Field49) Then
            Return $00
        EndIf
        If (((8.0 - crouchstate) + playersoundvolume) < entitydistance(collider, arg0\Field4)) Then
            Return $00
        EndIf
        If (1.0 < playersoundvolume) Then
            If (((60.0 < (Abs deltayaw(arg0\Field4, collider))) And entityvisible(arg0\Field4, collider)) <> 0) Then
                Return $01
            ElseIf (entityvisible(arg0\Field4, collider) = $00) Then
                If ((arg1 And crouch) <> 0) Then
                    Return $00
                Else
                    Return $02
                EndIf
            EndIf
        ElseIf (60.0 < (Abs deltayaw(arg0\Field4, collider))) Then
            Return $00
        EndIf
        Return entityvisible(arg0\Field4, collider)
    Else
        If (((8.0 - crouchstate) + playersoundvolume) < entitydistance(collider, arg0\Field4)) Then
            Return $03
        EndIf
        If (entityvisible(arg0\Field4, camera) <> 0) Then
            Return $01
        EndIf
        If (1.0 < playersoundvolume) Then
            Return $02
        EndIf
        Return $03
    EndIf
    Return $00
End Function
