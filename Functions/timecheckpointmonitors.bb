Function timecheckpointmonitors%()
    Local local0.fps_settings
    local0 = (First fps_settings)
    If (updatecheckpoint1 <> 0) Then
        If (100.0 > monitortimer) Then
            monitortimer = min((local0\Field3[$00] + monitortimer), 100.0)
        Else
            monitortimer = 0.0
        EndIf
    EndIf
    If (updatecheckpoint2 <> 0) Then
        If (100.0 > monitortimer2) Then
            monitortimer2 = min((local0\Field3[$00] + monitortimer2), 100.0)
        Else
            monitortimer2 = 0.0
        EndIf
    EndIf
    Return $00
End Function
